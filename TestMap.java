import java.util.*;

public class TestMap {
	
	public static void main(String[] args) {
		Map utopia = new Map(100.0);
		System.out.println(utopia.getDimension());
		City lol = new City(2.0,3.0);
		utopia.add(lol);
                City wow = new City(20,30);
		utopia.add(wow);
                //this is supposed not to work
                City far = new City(2000,3000);
		utopia.add(far);
		System.out.println(Arrays.toString(utopia.toArray()));
		utopia.remove(lol);
		System.out.println(Arrays.toString(utopia.toArray()));
		System.out.println(utopia.getCityCount());
		System.out.println("*******************************");
		Map myHome = new Map(5,10.0);
		City[] dummy = new City[5];
		System.out.println(Arrays.toString(myHome.toArray(dummy)));
	}
       
}
