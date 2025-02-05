package assignment1;

import java.util.ArrayList;

public class KNearestNeighbour extends Classifier {
	private int k;
	
	public KNearestNeighbour() {
		this.k = 0;
	}
	
	public KNearestNeighbour(int k) {
		this.k = k;
	}
	
	@Override
	int calculateOrientation(Data datapoint, ArrayList<Data> trainingData) {
		int orientation = 0;
		
		// if data set is empty or there is no k
		if (trainingData.isEmpty() || k == 0) {
			return orientation;
		}
		
		// list of k data
		Data[] kList = {trainingData.get(0), trainingData.get(0), trainingData.get(0)};
		
		for (int i = 0; i < trainingData.size(); i++) {
			Double distance = euclideanDistance(datapoint, trainingData.get(i));
			
			// set match and orientation to first index of data set
			if (i == 0) {

			}
		}
		
		
		return orientation;
	}
}
