import java.util.*;

public class TestRoute {
	public static void main(String args[]) {
		//build 3 cities
		City a = new City(0.0,0.0);
		City b = new City(1.0,1.0);
		City c = new City(1.0,2.0);
		//test the constructors: build 2 routes over the 3 cities
		City[] ca1 = new City[]{a,b,c};
		City[] ca2 = new City[]{a,c,b};
		Route r1 = new Route(ca1);
		Route r2 = new Route(ca2);
		//test the accessors
		System.out.println("Accessors for r1:");
		System.out.println(r1.getEnergy());
		System.out.println(r1.getCityArray());
		System.out.println(r1.getNumCities());
		System.out.println(r1.toString());
		//test the comparators
		System.out.println("Comparators:");
		System.out.println(r1.isBetterThan(r2));//false
		System.out.println(r1.equals(r2));//false
		//test the swap method
		System.out.println("Swapping r1...:");
		int[] swapInd = r1.swap();
		System.out.println(Arrays.toString(r1.getCityArray()));
		System.out.println(r1.equals(r2));//true
	}
}
