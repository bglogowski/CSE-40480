/**
 * Legacy.java
 * Legacy Sub Class for Assignment 2
 */

/**
 * @author Bryan Glogowski
 *
 */

import java.util.LinkedList;

public class Legacy extends Subaru {

    // Specific Subaru models have lists of trim levels and color options from which
    // to choose.
    private LinkedList<String> trimLevels = new LinkedList<>();
    private LinkedList<String> availableColors = new LinkedList<>();

    public Legacy() {

        super("Legacy");

        setTrimLevels();
        setAvailableColors();

        setColor(availableColors.get(0));
        setTrim(trimLevels.get(1));

        // These values are specific to the Subaru Legacy
        setGasTankSize(18.5);
        setMilesPerGallonHighway(34);
        setMilesPerGallonCity(25);

    }

    public Legacy(String trim, String color) {

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
        trimLevels.add("2.5i Sport");
        trimLevels.add("2.5i Limited");
        trimLevels.add("3.6R Limited");
    }

    public LinkedList<String> getAvailableColors() {
        return this.availableColors;
    }

    public void setAvailableColors() {
        availableColors.add("Tungsten Metallic");
        availableColors.add("Twilight Blue Metallic");
        availableColors.add("Lapis Blue Pearl");
        availableColors.add("Venetian Red Pearl");
        availableColors.add("Carbide Gray Metallic");
    }

}
