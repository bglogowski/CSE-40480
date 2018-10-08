import java.util.logging.Logger;

/**
 * Employee.java
 */

/**
 * An Employee is an object that contains information about an employee.
 * 
 * @author Bryan Glogowski
 * @version 1.0
 */

import java.util.logging.Logger;

public class Employee extends Person {

    private double hourlySalary, hoursWorked;
    private static final Logger log = Logger.getLogger(Employee.class.getName());

    /**
     * Create an Employee with a name, hourly salary and amount of hours worked.
     * 
     * @param name
     *            The name
     * @param hourlySalary
     *            The hourly salary
     * @param hoursWorked
     *            The hours worked
     */
    public Employee(String name, double hourlySalary, double hoursWorked) {
        super(name);
        this.setHourlySalary(hourlySalary);
        this.setHoursWorked(hoursWorked);
        log.info("Created Employee object");
    }

    /**
     * Return the hourly salary of the employee
     * 
     * @return The hourly salary
     */
    public double getHourlySalary() {
        return hourlySalary;
    }

    /**
     * Set the hourly salary of the employee
     * 
     * @param hourlySalary
     *            The hourly salary
     */
    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
        log.config("Changed the hourly salary for " + getName());
    }

    /**
     * Return the hours worked by the employee
     * 
     * @return The hours worked
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Set the hours worked for the employee
     * 
     * @param hoursWorked
     *            The hours worked
     */
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
        log.config("Changed the hours worked for " + getName());
    }

}
