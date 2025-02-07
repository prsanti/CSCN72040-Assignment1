package assignment1;

import java.util.Scanner;

public class Menu {
    private int classifierSelect;
    private int fileSelect;
    private Scanner scanner;

    public Menu() {
        classifierSelect = 0;
        fileSelect = 0;
        scanner = new Scanner(System.in);
    }

    // Getters
    public int getClassifierSelect() {
        return classifierSelect;
    }

    public int getFileSelect() {
        return fileSelect;
    }

    // Setters
    public void setClassifierSelect(int input) {
        this.classifierSelect = input;
    }

    public void setFileSelect(int input) {
        this.fileSelect = input;
    }

    // MEnu to let users select class 
    public int getClassifierSelection() {
        System.out.println("--- Select Classifier ---");
        System.out.println("1. Nearest Neighbour Classifier");
        System.out.println("2. K Nearest Neighbour Classifier");
        System.out.println("3. Another Classifier");
        System.out.println("4. Exit");

        System.out.print("Enter choice: ");
        classifierSelect = scanner.nextInt();
        return classifierSelect;
    }

    // Prompt user to select file
    public int getFileSelection() {
        System.out.println("--- Select File ---");
        System.out.println("1. unknownData.txt");
        System.out.println("2. testingData.txt");
        System.out.println("3. trainingData.txt");

        System.out.print("Enter choice: ");
        fileSelect = scanner.nextInt();
        return fileSelect;
    }

    // Display the menu and set selections
    public void displayMenu() {
        classifierSelect = getClassifierSelection();
        if (classifierSelect == 4) {
            System.out.println("Exiting program...");
            System.exit(0);
        }
        fileSelect = getFileSelection();
    }
}
