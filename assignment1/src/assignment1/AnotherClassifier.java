package assignment1;

import java.util.ArrayList;

public class AnotherClassifier extends Classifier {
	@Override
	int calculateOrientation(Data datapoint, ArrayList<Data> trainingData) {
		System.out.println("Another Classifier: calculateOrientation called");
		return 0;
	}
}
