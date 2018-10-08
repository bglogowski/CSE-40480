/**
 * Person.java
 */

/**
 * A Person is an object that contains information about a person.
 * 
 * @author Bryan Glogowski
 * @version 1.0
 */

import java.util.logging.Logger;

public class Person {

    private String name;
    private static final Logger log = Logger.getLogger(Person.class.getName());

    /**
     * Create a Person with a name
     * 
     * @param name
     *            The name
     */
    public Person(String name) {
        this.setName(name);
        log.info("Created Person object");
    }

    /**
     * Return the name of the person
     * 
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the person
     * 
     * @param name
     *            The name
     */
    public void setName(String name) {
        this.name = name;
        log.config("Changed the name for " + name);
    }

}