import java.util.*;

public class Boltzmann {
	//public static void main(String args[]) {
	//	System.out.println(boProb(-100.0,10.0));
	//}
	//computes the Boltzmann probablility from energy difference deltaE and temperature 
	private static Random rnd = new Random();
	private static double boProb(double deltaE, double temperature) {
		if (deltaE <= 0) return 1.0;
		else return Math.exp(- deltaE / temperature);
	}
	//accepts or rejects the new route according to the Boltzmann probablity
	public static boolean accept(double newE, double oldE, double temperature) {
		//calculate the Boltzmann probability
		double deltaE = newE - oldE;
		double prob = boProb(deltaE, temperature);
		//roll a dice
		double x = rnd.nextDouble();
		//and accept or reject
		if (x <= prob) return true;
		else return false;
	}
}
