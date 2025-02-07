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
                for (Data data : selectedData) {
                    int orientation = nn.calculateOrientation(data, trainingData);
                    data.setLabel(orientation);
                }
            }
            case 2 -> {
                KNearestNeighbour knn = new KNearestNeighbour(3);
                for (Data data : selectedData) {
                    int orientation = knn.calculateOrientation(data, trainingData);
                    data.setLabel(orientation);
                }
            }
            case 3 -> {
//                AnotherClassifier anotherClassifier = new AnotherClassifier();
//                anotherClassifier.calculateOrientation();
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
