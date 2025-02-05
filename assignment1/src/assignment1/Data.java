package assignment1;

public class Data {
	public double x;
	public double y;
	public double z;
	public int label;
	
	// constructor
	public Data() {
		x = 0;
		y = 0;
		z = 0;
		label = 0;
	}
	
	// constructor with parameters
	public Data(double a, double b, double c) {
		x = a;
		y = b;
		z = c;
		label = 0;
	}
	
	// constructor with parameters and label
	public Data(double a, double b, double c, int d) {
		x = a;
		y = b;
		z = c;
		label = d;
	}
	
	// getters
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public int getLabel() {
		return label;
	}
	
	// setters
	public void setX(double value) {
		this.x = value;
	}
	
	public void setY(double value) {
		this.y = value;
	}

	public void setZ(double value) {
		this.z = value;
	}
	
	public void setLabel(int value) {
		this.label = value;
	}
	
	// print orientation
	protected String getOrientation() {
		String orientationString = "";
		switch(this.label) {
			case(1):
				orientationString = "Face up";
				break;
			case(2):
				orientationString = "Face down";
				break;
			case(3):
				orientationString = "Portrait";
				break;
			case(4):
				orientationString = "Portrait upside down";
				break;
			case(5):
				orientationString = "Landscape left";
				break;
			case(6):
				orientationString = "Landscape right";
				break;
			default:
				break;
		}
		
		return orientationString;
	}
	
	public void print() {
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("z: " + z);
		System.out.println("label: " + label);
	}
}
