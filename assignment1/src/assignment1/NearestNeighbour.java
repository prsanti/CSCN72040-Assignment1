package assignment1;

import java.util.ArrayList;

public class NearestNeighbour extends Classifier {
	@Override
	int calculateOrientation(Data datapoint, ArrayList<Data> trainingData) {
		double match = 0;
		int orientation = 0;
		
		if (trainingData.size() == 0) {
			return 0;
		}
		
		for (int i = 0; i < trainingData.size(); i++) {			
			Double distance = euclideanDistance(datapoint, trainingData.get(i));
			
			// set match and orientation to first index of data set
			if (i == 0) {
				match = distance;
				orientation = trainingData.get(i).label;
			} else if (distance < match) {
				// if distance is less than match then it is the best fit
				match = distance;
				orientation = trainingData.get(i).label;
			}
		}
		
		return orientation;
	}
}
