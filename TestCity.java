import java.util.*;

//testing the class City.

public class TestCity {
        public static void main(String[] args) {
                //the constructors
                City new_york = new City(0.0,0.0);
                City princeton = new City(3.0,4.0);
                //the method getx, gety
                System.out.printf("Princeton is at: (%.2f,%.2f)\n",princeton.getx(),princeton.gety());
                //the method toString
                System.out.println(new_york.toString());
                //the method distanceto
                System.out.printf("The distance is: %.2f\n",princeton.distanceto(new_york));
                //the method equals
                System.out.println(new_york.equals(princeton));
        }
}


