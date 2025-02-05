package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class FileIO {
	 public ArrayList<Data> readFile(String filePath) {
		 	ArrayList<Data> dataset = new ArrayList<Data>();
	    	
	        try {
		   		File myObj = new File(filePath);
		   		Scanner myReader = new Scanner(myObj);
		  	      
		  	    while (myReader.hasNextLine()) {
			       String data = myReader.nextLine();
			       
			       // split line into values by comma
			       String[] values = data.split(",");
			       
			       // define values and convert values into correct type
			       Double x = Double.valueOf(values[0]);
			       Double y = Double.valueOf(values[1]);
			       Double z = Double.valueOf(values[2]);
			       int label = 0;
			       
			       // if label exists in dataset
			       if (values.length == 4) {
				       label = Integer.valueOf(values[3]);
			       }
			
			       // create Classifier
			       Data dataPoint = new Data(x, y, z, label);
			       
			       // add to data set
			       dataset.add(dataPoint);
			       
			     }
		  	    
		  	    myReader.close();
	
		        } catch (FileNotFoundException e) {
		        	System.out.println("Error opening file");
		            e.printStackTrace();
	        }
	        
	  	    return dataset;
	    }
	 
	 public void writeFile(ArrayList<Data> dataset) {
		 try {
			 // write to path
			 FileWriter writer = new FileWriter("src/data/result.txt");
			 
			 // loop through dataset and write
			 for(int i = 0; i < dataset.size(); i++) {
				 writer.write(dataset.get(i).x + "," +
					 			dataset.get(i).y + "," +
						 		dataset.get(i).z + "," +
					 			dataset.get(i).label + "\n");
			 }
			 
			 writer.close();
			 System.out.println("Successfully wrote to result.txt");
			 
		 } catch (IOException e) {
			 System.out.println("An error occured.");
			 e.printStackTrace();
		 }
	 }
	 
}
