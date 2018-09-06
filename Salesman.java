import java.util.*;

public class Salesman {
	public static void main(String args[]) {
		//construct a random 10*10 map with 5 cities... 
		int numCities = 10;
		int successCount = 0;
		//start timing
		long startTime = System.nanoTime();
		//try many initial conditions
		for (int count = 1; count <= 100; count++) {
			Map m = new Map(numCities,100.0);
			City[] dummy = new City[numCities];
			City[] caInitial = m.toArray(dummy);
			
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			//for a predetermined city configuration:
			//City a = new City(-20,-10);
			//City b = new City(30,30);
			//City c = new City(20,10);
			//City d = new City(20,-10);
			//City e = new City(-20,10);
			//City[] caInitial = new City[]{a,b,c,d,e};
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
			//guess an initial route
			Route trial = new Route(caInitial); 
			//the "record low" energy
			double recordLowE = trial.getEnergy();
			System.out.println(recordLowE);
			
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			//build a queue for the most recent 100 energies::
			//LinkedList<Double> mostRecentEnergies = new LinkedList<Double>();
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
			//begin our swap and try!
			//reducing the temperature along the way!
			for (double temperature = 5.01; temperature >= 0.01; temperature = temperature - 0.5) {
				//System.out.println("Temperature now = " + Double.toString(temperature));
				int numAccept = 0;
				while (numAccept < 100) {
					double oldE = trial.getEnergy();
					Route oldTrial = deepCopy(trial);
					int[] swapInd = trial.swap();
					double newE = trial.getEnergy();
					if (newE < recordLowE) recordLowE = newE;
					if (Boltzmann.accept(newE,oldE,temperature)) {
						//mostRecentEnergies.add(newE);
						numAccept++;
						//System.out.println(Integer.toString(numAccept)+" "+Double.toString(newE));
						//if (numAccept > 200) {
						//	mostRecentEnergies.remove();
						//	double avrE = avr(mostRecentEnergies);
						//	System.out.println(Integer.toString(numAccept)+" "+Double.toString(avrE));
						//}
				
					}
					else trial = oldTrial;//swap back because rejected by Boltzmann
				}
			}
			Route finalRoute = trial;
			System.out.println(finalRoute);//uses final.toString
			System.out.println("record lowest energy = " + Double.toString(recordLowE));
			if (Math.abs(recordLowE - finalRoute.getEnergy()) < 0.00001) {
				System.out.println("success");
				successCount++;
			}
			else System.out.println("failure");
		}
		//end timing
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Your run time is " + Long.toString(totalTime) + " nanoseconds.");

		double successRate = successCount/100.0;
		System.out.println("success rate = "+Double.toString(successRate));
	}

	//copies a route, but a completely different object!
	private static Route deepCopy(Route source) {
		City[] cityArrCopy = new City[source.getNumCities()];
		City[] cityArrOri = source.getCityArray();
		for (int i = 0; i < source.getNumCities(); i++) {
			City c = cityArrOri[i];
			City temp = new City(c.getx(),c.gety());
			cityArrCopy[i] = temp;
		}
		Route copied = new Route(cityArrCopy);
		return copied;
	}
	//computes the average of a linked list of doubles
	private static double avr(LinkedList<Double> q) {
		double sum = 0;
		for (int i = 0; i < q.size(); i++) {
			sum = sum + q.get(i);
		}
		return sum / (double) q.size();
	}
	
}
