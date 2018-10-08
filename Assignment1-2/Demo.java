/**
 * Demo.java:
 * Demo for Assignment 2
 */

/**
 * @author Bryan Glogowski
 *
 */

import java.util.Random;

public class Demo {

    public static void main(String[] args) {

        Forester forester1 = new Forester();
        Forester forester2 = new Forester("2.5i Touring", "Quartz Blue Pearl");
        
        // Test overriding the equals() method.
        if(forester1.equals(forester2)) {
            System.out.println("WRONG: forester1 equals forester2");
        } else {
            System.out.println("CORRECT: forester1 does not equal forester2");
        }


        Legacy legacy = new Legacy();

        Outback outback = new Outback("3.6R Flying", "Quartz Blue Pearl");
        
        // Testing the Copy Constructor
        Subaru outbackCopy = new Subaru(outback);
        
     // Test overriding the equals() method.
        if(outback.equals(outbackCopy)) {
            System.out.println("CORRECT: outback equals outbackCopy");
            
        } else {
            System.out.println("WRONG: outback does not equal outbackCopy");
        }

        WRX wrx1 = new WRX();
        WRX wrx2 = new WRX("WRX Premium", "Crystal Black Silica");
        
        

        Subaru[] carCollection = { forester1, forester2, legacy, outback, outbackCopy, wrx1, wrx2 };

        // Set the min. & max. miles to be driven
        double min = 2.0;
        double max = 400.0;

        // For each Subaru...
        for (Subaru s : carCollection) {

            // ...go on 10 random trips with the family
            for (int i = 1; i <= 10; i++) {

                // Add 10 gallons to the tank regardless of the distance
                s.addGas(10.0);

                // Go a random distance
                Random rand = new Random();
                double random = min + rand.nextDouble() * (max - min);
                s.increaseMileage(random);

            }

        }

        // Show the results of the test:
        for (Subaru s : carCollection) {
            System.out.println("-----------------------------------");
            s.display();
            
            System.out.print("Subaru Class counter value = ");
            s.displayCounter();
        }
    }

}
