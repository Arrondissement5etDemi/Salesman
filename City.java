import java.util.*;

public class City implements Comparable<City> {
        //data
	private double x,y;

	//constructor
        public City(double xx, double yy) {
		x = xx;
                y = yy;
        }

        //gets the coordinates
        public double getx() {
		return x;
	}
    
	public double gety() {
		return y;
	}

	//distance to another city
	public double distanceto(City another_city) {
		double anotherX = another_city.getx();
                double anotherY = another_city.gety();
                return Math.sqrt(Math.pow((x - anotherX),2) + Math.pow((y - anotherY),2));
	}

	public boolean equals(City anotherCity) {
		return (x == anotherCity.getx() && y == anotherCity.gety());
	}

	public int compareTo (City anotherCity) {
		double ax = anotherCity.getx();
		double ay = anotherCity.gety();
		if (x == ax && y == ay) {
			return 0;
		}
		else if (x < ax || (x == ax && y < ay)) {
			return -1;
		}
		else return 1;
	}

    
	public String toString() {
		return "(" + Double.toString(x) + "," + Double.toString(y) + ")";
	}
}
