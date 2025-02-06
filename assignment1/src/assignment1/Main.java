package assignment1;
import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// array list of data set
		ArrayList<Data> trainingData;
		ArrayList<Data> testingData;
		ArrayList<Data> unknownData;

		// path to files
		String trainingDataPath = "src/data/trainingData.txt";
		String testingDataPath = "src/data/testingData.txt";
		String unknownDataPath = "src/data/unknownData.txt";
		
		// initialize file manager
		FileIO fileManager = new FileIO();
		
		// read training data and set to array list
		trainingData = fileManager.readFile(trainingDataPath);
		// read testing
		testingData = fileManager.readFile(testingDataPath);
		// read unknown
		unknownData = fileManager.readFile(unknownDataPath);
		
		// run nn on unknown data
//		for (int i = 0; i < unknownData.size(); i++) {
//			NearestNeighbour nn = new NearestNeighbour();
//			int orientation = nn.calculateOrientation(unknownData.get(i), trainingData);
//			
//			// set label to calculated orientation
//			unknownData.get(i).setLabel(orientation);
//		}
//		
//		fileManager.writeFile(unknownData);
		
		// knn
		// run on testing data
		for (int i = 0; i < testingData.size(); i++) {
//			System.out.println("before");
//			testingData.get(i).print();
			KNearestNeighbour knn = new KNearestNeighbour(3);
			int orientation = knn.calculateOrientation(testingData.get(i), trainingData);
			
			// set label to calculated orientation
			testingData.get(i).setLabel(orientation);
//			
//			System.out.println("after:");
//			testingData.get(i).print();
		}
		
		fileManager.writeFile(unknownData);
		
	}

}
