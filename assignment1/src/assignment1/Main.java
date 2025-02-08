package assignment1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // ArrayLists for datasets
        ArrayList<Data> trainingData;
        ArrayList<Data> testingData;
        ArrayList<Data> unknownData;

        // File paths
        String trainingDataPath = "src/data/trainingData.txt";
        String testingDataPath = "src/data/testingData.txt";
        String unknownDataPath = "src/data/unknownData.txt";

        // Initialize file manager
        FileIO fileManager = new FileIO();

        // Read data from files
        trainingData = fileManager.readFile(trainingDataPath);
        testingData = fileManager.readFile(testingDataPath);
        unknownData = fileManager.readFile(unknownDataPath);

        // Initialize menu and prompt user
        Menu menu = new Menu();
        menu.displayMenu();

        // Select dataset based on user input
        ArrayList<Data> selectedData = switch (menu.getFileSelect()) {
            case 1 -> unknownData;
            case 2 -> testingData;
            case 3 -> trainingData;
            default -> {
                System.out.println("Invalid file selection. Exiting.");
                System.exit(0);
                yield null;
            }
        };

        // Run classifier based on user selection
        switch (menu.getClassifierSelect()) {
            case 1 -> {
                NearestNeighbour nn = new NearestNeighbour();
                // loop through selected data
                for (Data data : selectedData) {
                	// calculate orientation from training data
                    int orientation = nn.calculateOrientation(data, trainingData);
                    // set label orientation
                    data.setLabel(orientation);
                }
            }
            case 2 -> {
            	// set knn to 3
                KNearestNeighbour knn = new KNearestNeighbour(3);
                // loop through selected data
                for (Data data : selectedData) {
                	// calculate orientation from training data
                    int orientation = knn.calculateOrientation(data, trainingData);
                    // set label orientation
                    data.setLabel(orientation);
                }
            }
            case 3 -> {
                AnotherClassifier anotherClassifier = new AnotherClassifier();
                // create sample data
                Data data = selectedData.get(0);
                // call another classifier function
                anotherClassifier.calculateOrientation(data, trainingData);
            }
            case 4 -> {
                System.out.println("Exiting...");
                System.exit(0);
            }
            default -> System.out.println("Invalid classifier selection.");
        }

        // Write updated data back to file
        fileManager.writeFile(selectedData);
    }
}
