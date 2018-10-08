/**
 * Forester.java
 * Forester Sub Class for Assignment 2
 */

/**
 * @author Bryan Glogowski
 *
 */

import java.util.LinkedList;

public class Forester extends Subaru {

    // Specific Subaru models have lists of trim levels and color options from which
    // to choose.
    private LinkedList<String> trimLevels = new LinkedList<>();
    private LinkedList<String> availableColors = new LinkedList<>();

    public Forester() {

        super("Forester");

        setTrimLevels();
        setAvailableColors();

        setColor(availableColors.get(2));
        setTrim(trimLevels.get(1));

        // These values are specific to the Subaru Forester
        super.gasTankSize = 15.9;
        super.milesPerGallonHighway = 27;
        super.milesPerGallonCity = 23;

    }

    public Forester(String trim, String color) {

        this();

        if (this.trimLevels.contains(trim)) {
            setTrim(trim);
        } else {
            System.out.format("Trim level %s in not available, setting trim level to %s.%n", trim, getTrim());
        }

        if (this.availableColors.contains(color)) {
            setColor(color);
        } else {
            System.out.format("Color %s in not available, setting color to %s.%n", color, getColor());
        }

    }

    public void display() {
        System.out.format("Love. It's what makes a Subaru %s, a Subaru %s.", getModel(), getModel());
        System.out.println();
        System.out.println(toString());
        System.out.println("Available in the following trim levels and colors:");
        System.out.println(this.trimLevels.toString());
        System.out.println(this.availableColors.toString());
    }

    public LinkedList<String> getTrimLevels() {
        return this.trimLevels;
    }

    public void setTrimLevels() {
        trimLevels.add("2.5i");
        trimLevels.add("2.5i Premium");
        trimLevels.add("2.5i Limited");
        trimLevels.add("2.5i Touring");
        trimLevels.add("2.0XT Premium");
        trimLevels.add("2.0XT Touring");
    }

    public LinkedList<String> getAvailableColors() {
        return this.availableColors;
    }

    public void setAvailableColors() {
        availableColors.add("Crystal White Pearl");
        availableColors.add("Ice Silver Metallic");
        availableColors.add("Burnished Bronze Metallic");
        availableColors.add("Quartz Blue Pearl");
        availableColors.add("Venetian Red Pearl");
        availableColors.add("Jasmine Green Metallic");
        availableColors.add("Dark Gray Metallic");
        availableColors.add("Crystal Black Silica");
    }

}
