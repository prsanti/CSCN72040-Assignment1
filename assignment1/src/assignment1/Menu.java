package assignment1;

import java.util.Scanner;

public class Menu {
	int classifierSelect;
	int fileSelect;
	
	public Menu() {
		classifierSelect = 0;
		fileSelect = 0;
	}
	
	// getters
	public int getClassifierSelect() {
		return classifierSelect;
	}
	
	public int getFileSelect() {
		return fileSelect;
	}
	
	// setters
	public void setClassifierSelect(int input) {
		this.classifierSelect = input;
	}
	
	public void setFileSelect(int input) {
		this.fileSelect = input;
	}
	
	protected void getClassifier() {
        System.out.println("--- Select Classifier ---");
        System.out.println("1. Nearest Neighbour Classifier");
        System.out.println("2. K Nearest Neighbour Classifier");
        System.out.println("3. Another Classifier");
        System.out.println("4. Exit");
	}
	
	private void getFile() {
        System.out.println("--- Select File ---");
        System.out.println("1. unkownData.txt");
        System.out.println("2. testingData.txt");
        System.out.println("3. trainingData.txt");
//        System.out.println("4. Exit");
	}
}
