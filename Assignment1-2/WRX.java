/**
 * WRX.java
 * WRX Sub Class for Assignment 2
 */

/**
 * @author Bryan Glogowski
 *
 */

import java.util.LinkedList;

public class WRX extends Subaru {

    // Specific Subaru models have lists of trim levels and color options from which
    // to choose.
    private LinkedList<String> trimLevels = new LinkedList<>();
    private LinkedList<String> availableColors = new LinkedList<>();

    public WRX() {

        super("WRX");

        setTrimLevels();
        setTrim(trimLevels.get(3));

        setAvailableColors();
        setColor(availableColors.get(3));

        // These values are specific to the Subaru WRX
        setGasTankSize(15.9);
        setMilesPerGallonHighway(27);
        setMilesPerGallonCity(20);

    }

    public WRX(String trim, String color) {

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
        trimLevels.add("WRX");
        trimLevels.add("WRX Premium");
        trimLevels.add("WRX Limited");
        trimLevels.add("WRX STI");
        trimLevels.add("WRX STI Limited");
    }

    public LinkedList<String> getAvailableColors() {
        return this.availableColors;
    }

    public void setAvailableColors() {
        availableColors.add("Crystal White Pearl");
        availableColors.add("Ice Silver Metallic");
        availableColors.add("Pure Red");
        availableColors.add("WR Blue Pearl");
        availableColors.add("Lapis Blue Pearl");
        availableColors.add("Dark Gray Metallic");
        availableColors.add("Crystal Black Silica");
    }

}
