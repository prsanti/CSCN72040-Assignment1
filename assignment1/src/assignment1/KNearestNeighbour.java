package assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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
//		ArrayList<Data, Double> testArrayList;
		// dictionary of datapoint and distance
//		Map<Data, Double> dataDistance = new HashMap<>();
		
		ArrayList<DataDistance> dataDistancePair = new ArrayList<DataDistance>();
		
		// loop through array list of training data
		for (int i = 0; i < trainingData.size(); i++) {
			// calculate distance between datapoint and each training data
			Double distance = euclideanDistance(datapoint, trainingData.get(i));
			
			// add data and distance pair to new array list
			dataDistancePair.add(new DataDistance(datapoint, distance));
		}
		
//		for (int i = 0; i < dataDistancePair.size(); i++) {
//			dataDistancePair.get(i).data.print();
//			System.out.println(dataDistancePair.get(i).distance);
//		}
		
		// sort data pair by distance ascending
		Collections.sort(dataDistancePair, Comparator.comparingDouble(d -> d.distance));
		
		
//		for (int i = 0; i < dataDistancePair.size(); i++) {
//			dataDistancePair.get(i).data.print();
//			System.out.println(dataDistancePair.get(i).distance);
//		}
		
		// dictionary of label and counts
		Map<Integer, Integer> labelCountsMap = new HashMap<Integer, Integer>();
		
		// loop depending on min size of k and data distance pair to prevent error
		for(int i = 0; i < Math.min(k, dataDistancePair.size()); i++) {
			// get label
			int label = dataDistancePair.get(i).data.label;
			// add to Map, get value or set to 0 and add 1
			labelCountsMap.put(label, labelCountsMap.getOrDefault(label, 0) + 1);
		}
		
		orientation = majorityVote(labelCountsMap);
		
		return orientation;
	}
	
	// helper class for data and distance to datapoint
	private class DataDistance {
		Data data;
		Double distance;
		
		public DataDistance(Data data, Double distance) {
			this.data = data;
			this.distance = distance;
		}
	}
	
	private int majorityVote(Map<Integer, Integer> labelCountsMap) {
		int highestCount = 0;
		
		// loop through Map
		for(Integer key : labelCountsMap.keySet()) {
			// get highest value and set count to the key
			if (labelCountsMap.get(key) > highestCount) {
				highestCount = key;
			}
		}

		return highestCount;
	}
}
