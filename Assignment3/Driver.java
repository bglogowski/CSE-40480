/**
 * Driver.java
 */

/**
 * The Driver class contains the main method to demonstrate the code for my assignment.
 * 
 * @author Bryan Glogowski
 * @version 1.0
 * 
 */

import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class Driver {

    private static LinkedList<Employee> employees = new LinkedList<>();
    private static Scanner sc;
    private static final Logger log = Logger.getLogger(Driver.class.getName());

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        int numberOfEmployees = 0;
        boolean inputRequired = true;

        String name = new String();

        double hourlySalary = 0.0, hoursWorked = 0.0;

        sc = new Scanner(System.in);

        while (inputRequired) {

            try {

                System.out.println("Enter the number of employees:");
                numberOfEmployees = Integer.parseInt(sc.next());
                inputRequired = false;

            } catch (NumberFormatException e) {

                System.out.println("There was a problem with your input, please try again...");
                log.warning("Caught NumberFormatException during input");

            }
        }

        for (int entry = 1; entry <= numberOfEmployees; entry++) {

            inputRequired = true;

            System.out.println("Begin data entry for employee #" + entry);

            while (inputRequired) {

                try {

                    System.out.println("Enter an employee name:");
                    name = sc.next();

                    System.out.println("Enter an hourly salary:");
                    hourlySalary = Double.parseDouble(sc.next());

                    System.out.println("Enter the number of hours worked:");
                    hoursWorked = Double.parseDouble(sc.next());

                    inputRequired = false;
                    log.info("Input for entry succeeded");

                } catch (NumberFormatException e) {

                    System.out.println("There was a problem with your input, please try again...");
                    log.warning("Caught NumberFormatException during input");

                }

            }

            employees.add(new Employee(name, hourlySalary, hoursWorked));
            log.info("Added employee to employee list");

        }

        printSalaryReport();

    }

    public static void printSalaryReport() throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter("employee.csv", "UTF-8");
        log.info("File opened");

        writer.println("Employee Name, Salary, Hours, Weekly Pay");
        for (Employee e : employees) {
            log.info("Found employee " + e.getName());
            writer.println(e.getName() + ", " + e.getHourlySalary() + ", " + e.getHoursWorked() + ", "
                    + e.getHourlySalary() * e.getHoursWorked());
        }
        writer.close();
        log.info("File closed");

    }

}
