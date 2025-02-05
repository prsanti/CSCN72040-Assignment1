package assignment1;

import java.util.ArrayList;

public abstract class Classifier {
	abstract int calculateOrientation(Data datapoint, ArrayList<Data> dataset);
	
	protected double euclideanDistance(Data newData, Data trainingData) {
		Double distance = Math.sqrt(
			Math.pow(newData.x - trainingData.x, 2) +
			Math.pow(newData.y - trainingData.y, 2) +
			Math.pow(newData.z - trainingData.z, 2));
		
		return distance;
	}
}
