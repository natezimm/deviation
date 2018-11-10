/**
 * Program will accept data input as simple text
 * Each double value appears on its own line
 * Deviation computed for each value
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Deviate
{    
    public static void main(String[] args) throws FileNotFoundException
    {            
        // User is asked to provide input file name
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        
        // Get scanner object ready for reading
        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);
       
        // Initialize and set variables used to 0
        double total = 0.0; 
        double average = 0.0;
        double deviation = 0.0;
        
        /** Create and format strings for headers       
         * Print headers to the screen
         */
        String lineNumberHeading = "Line number";
        String valueHeading = "Value";
        String deviationHeading = "Deviation";
        System.out.printf("%-15s %8s %15s %n" , lineNumberHeading, valueHeading, deviationHeading);
        
        // ArrayList is created to hold all of the values
        ArrayList<Double> valuesList =  new ArrayList<Double>();
        while (in.hasNextDouble())
        {
            double value = in.nextDouble();
            valuesList.add(value);           
        }
        
        // Create array with the values
        Double values[]= new Double[valuesList.size()];
        values = valuesList.toArray(values);
        
        // Add values together for one total
        for (int i = 0; i < values.length; i++)
        {
            total += values[i];
        }
        
        // Calculate the average which is need for deviation
        average = total / values.length;
        System.out.printf("%-10s %10.4f \n", "Average of all values = ", average);
        
        // Calculate deviation and print into table
        for (int i = 0; i < values.length; i++)
        {
            double value = values[i];
            deviation = Math.abs(average - value);
            System.out.printf("%-15.0f %8.4f %15.4f \n",(double) i + 1, value, deviation);
        }
        
        // Close the scanner
        in.close(); 
        console.close();
        
    }

}
