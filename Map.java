import java.util.*;

public class Map {
	private double dimension;
	private AbstractSet<City> citySet;


	public Map(double d) {
		dimension = d;
                citySet = new TreeSet<City>();
	}
	
	//randomly construct a map with numCities cities and dimension d*d
	public Map(int numCities, double d) {
		dimension = d;
		citySet = new TreeSet<City>();
		for (int i = 1; i <= numCities; i++) {
			double x = getRandomNumberInRange(0.0,(double) d);
			double y = getRandomNumberInRange(0.0,(double) d);
			City c = new City(x,y);
			add(c);
		}
	}

	//accessors
	public double getDimension() {
		return dimension;
	}

	public int getCityCount() {
		return citySet.size();
	}

	//adds a city to the map
	public boolean add(City c) {
		if (c.getx() <= dimension && c.gety() <= dimension) {
			return citySet.add(c);
		}
		else {
			return false;
		}
	}
	//removes a city from the map
	public boolean remove(City c) {
		return citySet.remove(c);
	}	

	public Object[] toArray() {
		return citySet.toArray();
	}
	public <City> City[] toArray(City[] ca) {
		return citySet.toArray(ca);
	}

	//auxillary function
	private static double getRandomNumberInRange(double min, double max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
                }
	        Random r = new Random();
	        return r.nextDouble()*(max - min) + min;
	}	
}
