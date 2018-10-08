/**
 * Subaru.java
 * Subaru Class for Assignment 2
 * 
 * Love. It's what makes a Subaru, a Subaru.
 * 
 * 
 */

/**
 * @author Bryan Glogowski
 *
 */

import java.time.Year;
import java.util.Random;

public class Subaru {

    // Keep track of how many Subarus are created.
    private static int counter = 0;

    // The make of a Subaru is always "Subaru".
    private static final String MAKE = "Subaru";

    // Define some default values for Subarus that don't have these values defined.
    private static final String DEFAULT_MODEL = "Passenger Vehicle";
    private static final String DEFAULT_TRIM = "Standard";
    private static final String DEFAULT_COLOR = "Dark Cerulean";

    // Once a Subaru is created, it cannot change its model year.
    private final int YEAR;

    // Theoretically, the model, trim and color can be modified after creation.
    private String model, trim, color;

    // Under normal operating conditions, the mileage and gas level will change.
    private double mileage, gasLevel;

    // The gas tank size can be modified.
    protected double gasTankSize;

    // Unless otherwise specified, Subarus have a default MPG rating of 25.
    protected int milesPerGallonHighway, milesPerGallonCity = 25;

    // Default constructor with no arguments.
    public Subaru() {
        // Call the "standard" 3-argument constructor with default values.
        this(Subaru.DEFAULT_MODEL, Subaru.DEFAULT_TRIM, Subaru.DEFAULT_COLOR);
    }

    public Subaru(String model) {
        this(model, Subaru.DEFAULT_TRIM, Subaru.DEFAULT_COLOR);
    }

    // Standard constructor to create Subaru objects.
    public Subaru(String model, String trim, String color) {
        this.YEAR = Year.now().getValue();
        this.mileage = 0.0;
        this.gasLevel = getGasTankSize() - 0.5;
        this.model = model;
        this.trim = trim;
        this.color = color;

        // Increment object counter
        Subaru.counter++;
    }

    // Copy constructor
    Subaru(Subaru s) {
        this.YEAR = s.getYear();
        this.mileage = s.getMileage();
        this.gasLevel = s.getGasLevel();
        this.model = s.getModel();
        this.trim = s.getTrim();
        this.color = s.getColor();
        this.milesPerGallonHighway = s.getMilesPerGallonHighway();
        this.milesPerGallonCity = s.getMilesPerGallonCityl();

        // Increment object counter
        Subaru.counter++;
    }

    // Print out details about the Subaru
    public void display() {
        System.out.println("Love. It's what makes a Subaru, a Subaru.");
        System.out.println();
        System.out.println(toString());
    }

    public void displayCounter() {
        System.out.println(Subaru.counter);
    }

    // Accessor / Mutator methods

    public String getMake() {
        return this.MAKE;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return this.YEAR;
    }

    public String getTrim() {
        return this.trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Anyone can get the mileage...
    public double getMileage() {
        return this.mileage;
    }

    // ...but only internal processes can set it.
    private void setMileage(double miles) {
        this.mileage = miles;
    }

    public double getGasTankSize() {
        return this.gasTankSize;
    }

    public void setGasTankSize(double gallons) {
        this.gasTankSize = gallons;
    }

    public double getGasLevel() {
        return this.gasLevel;
    }

    private void setGasLevel(double gallons) {
        this.gasLevel = gallons;
    }

    public int getMilesPerGallonHighway() {
        return this.milesPerGallonHighway;
    }

    public void setMilesPerGallonHighway(int mpg) {
        this.milesPerGallonHighway = mpg;
    }

    public int getMilesPerGallonCityl() {
        return this.milesPerGallonCity;
    }

    public void setMilesPerGallonCity(int mpg) {
        this.milesPerGallonCity = mpg;
    }

    // Get a random MPG number between City & Highway ratings
    private int getRandomMilesPerGallon() {
        Random rand = new Random();
        return rand.nextInt(milesPerGallonHighway - milesPerGallonCity) + milesPerGallonCity;
    }

    // Users can add gas to the car by filling the tank.
    public void addGas(double gallons) {
        if (gallons > 0.0) {
            // Gas levels cannot exceed the tank size
            if (this.gasLevel + gallons > this.gasTankSize) {
                this.gasLevel = this.gasTankSize;
            } else {
                this.gasLevel = this.gasLevel + gallons;
            }
        } else {
            System.out.println("Removing gas from the tank is not allowed.");
        }
    }

    // The only way to decrease gas level is to increase mileage.
    private void decreaseGasLevel(double gallons) {
        // Gas levels cannot be negative
        if (gasLevel - gallons > 0.0) {
            this.gasLevel = gasLevel - gallons;
        } else {
            this.gasLevel = 0.0;
        }
    }

    // Users can add mileage to the car by driving it.
    public void increaseMileage(double miles) {

        if (miles > 0.0) {

            // Determine a random MPG for the trip.
            int tripMilesPerGallon = getRandomMilesPerGallon();

            // Find out how far the car can go based on gas & MPG.
            double milesPossible = gasLevel * tripMilesPerGallon;

            // Set the mileage and gas level accordingly
            if (miles < milesPossible) {
                setMileage(mileage + miles);
                decreaseGasLevel(miles / tripMilesPerGallon);
            } else {
                setMileage(mileage + milesPossible);
                setGasLevel(0.0);

                System.out.format("The gas tank is empty for:%n%s%n", toString());

            }

        } else {
            System.out.println("Decreasing mileage is not permitted.");
        }

    }

    // Override methods.
    @Override
    public String toString() {
        return String.format(
                "Make: %s%n" + "Model: %s%n" + "Model Year: %s%n" + "Trim Level: %s%n" + "Color: %s%n"
                        + "Mileage: %.1f, Gas Level: %.2f%n",
                Subaru.MAKE, this.model, this.YEAR, this.trim, this.color, this.mileage, this.gasLevel);
    }

    @Override
    public boolean equals(Object obj) {

        // If the object is compared with itself, return true
        if (obj == this) {
            return true;
        }

        // If the object is not a Subaru, return false.
        if (!(obj instanceof Subaru)) {
            return false;
        }

        // Cast the object as a Subaru
        Subaru s = (Subaru) obj;

        // Compare the attributes of the other Object and this Object
        return this.YEAR == s.getYear() && this.mileage == s.getMileage() && this.gasLevel == s.getGasLevel()
                && this.model == s.getModel() && this.trim == s.getTrim() && this.color == s.getColor()
                && this.milesPerGallonHighway == s.getMilesPerGallonHighway()
                && this.milesPerGallonCity == s.getMilesPerGallonCityl();

    }

}
