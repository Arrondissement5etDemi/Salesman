import java.util.*;

public class Route {
	private double energy;
	private City[] cityArray;
	private int numCities;
	//constructors
	public Route(City[] ca) {
		setRoute(ca);
	}
	//accessors
	public double getEnergy() {
		return energy;
	}
	public City[] getCityArray() {
		return cityArray;
	}
	public int getNumCities() {
		return numCities;
	}
	//set up using a given city array
	public void setRoute(City[] ca) {
		cityArray = ca;
                numCities = ca.length;
                energy = 0;
                int lastIndex = cityArray.length - 1;
                for (int i = 0; i < lastIndex; i++)
                        energy += cityArray[i].distanceto(cityArray[i+1]);
                energy += cityArray[lastIndex].distanceto(cityArray[0]);
	}
	//set up using a given map //don't know if it's correct yet
	public void setRoute(Map m) {
		City[] dummy = new City[1];
		City[] ca = m.toArray(dummy);
		setRoute(ca);
	}
	//swaps cities indexed by m and n along the route
	public void swap(int m, int n) {
		if (m <= numCities && n <= numCities) {
			City temp = cityArray[m];
			cityArray[m] = cityArray[n];
			cityArray[n] = temp;
			setRoute(cityArray);
		}
	}
	//swaps 2 random cities
	public int[] swap() {
		int[] swapInd = new int[2];
		swapInd[0] = getRandomNumberInRange(0,numCities - 1);
		swapInd[1] = getRandomNumberInRange(0,numCities - 1);
		swap(swapInd[0],swapInd[1]);
		return swapInd;
	}
	//auxillary function
	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	//comparators
	//compares if this route is better (lower energy) than another route
	public boolean isBetterThan(Route another) {
		return energy < another.getEnergy();
	}
	//determines if this route and another route are equivalent wrt circular and reversal symmetry
	public boolean equals(Route another) {
		if (circular(another)) return true;
		//create a reversed cityarray
		City[] rev = new City[numCities];
		for (int j = 0; j < numCities; j++) {
			rev[j] = cityArray[numCities - 1 - j];
		}
		//
		Route revRoute = new Route(rev);
		if (revRoute.circular(another)) return true;
		return false;
	}
	//determines if this route and another route are equivalent wrt circular symmetry
	public boolean circular(Route another) {
		for (int phase = 0; phase <= numCities - 1; phase++) {
			City[] temp = new City[numCities];
			for (int j = 0; j < numCities; j++) {
				temp[j] = cityArray[(j + phase) % numCities];
			}
			boolean identical = true;
			City[] anotherArr = another.getCityArray();
			for (int i = 0; i < numCities; i++) {
				if (!temp[i].equals(anotherArr[i])) {
					identical = false;
					break;
				}
			}
			if (identical) return true;
		}
		return false;
	}
	//toString
	public String toString() {
		String result = new String();
		for (int i = 0; i < numCities; i++) {
			result = result + cityArray[i].toString() + "\n";
		}
		return result + "\nEnergy: " + Double.toString(energy) + "\nThere are " + Integer.toString(numCities) + " cities.";
	}

	
}



