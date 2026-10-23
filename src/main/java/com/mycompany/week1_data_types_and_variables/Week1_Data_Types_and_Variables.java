/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.week1_data_types_and_variables;

/**
 *
 * @author kathe
 */
public class Week1_Data_Types_and_Variables {

    public static void main(String[] args) {
    System.out.println("==========Personal Profile Printer==========");
    
       String fullname = "Kaeley Stace Salvacion";
        
        int age = 19;
        double height = 5.0;
        char initial = 'C';
        boolean studentstatus = true;
        
        System.out.println("Full Name: " + fullname);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height + "feet");
        System.out.println("Initial: " + initial);
        System.out.println("Student Status: " + studentstatus);
        
    }
}
    public static void main(String[] args) {
    System.out.println("==========Type Safe Shopping Calculator==========");
        
        int quantity = 5; 
        double unitPrice = 19.50; 
        String storeName = "Kae Store"; 

        double totalCost = quantity * unitPrice; 

        System.out.println("Store Name: " + storeName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Total Cost: " + totalCost);
        
        /*We shouldn't use an int for totalCost because it might have a decimals for the cents.
        Using a double is better so we don't lose any money or precision when figuring out the final price.*/
    }

    public static void main(String[] args) {
    System.out.println("==========Unit Casting Converter==========");
        double centimeters = 700.10; 
        
        int meters = (int) (centimeters / 100); 
        double remainingCentimeters = centimeters % 100; 
        
        System.out.println("Equivalent: " + meters + " meters and " + remainingCentimeters + " centimeters.");

        int wholeNumber = 5;
        double widenedValue = wholeNumber; 
        System.out.println("Implicit Widening: " + wholeNumber + " as double is " + widenedValue);
        /*No cast needed because double has a larger range than int.
        Java automatically widens it with zero data loss*/

        double decimalValue = 7.10;
        int narrowedValue = (int) decimalValue; 
        System.out.println("Explicit Narrowing: " + decimalValue + " as int is " + narrowedValue);
        /*Explicit cast is required, the decimal portion (.10) is dropped and lost, converting 7.10 down to 7.*/
    }

    public static void main(String[] args) {
    System.out.println("==========Overflow & Reference Investigator==========");
    
        byte b = 127;
        System.out.println("Original byte value: " + b);
        b++;
        System.out.println("After incrementing: " + b);

        String str1 = new String("Java");
        String str2 = new String("Java");
        String str3 = "Java";

        System.out.println("Comparing str1 and str2 with == : " + (str1 == str2));
        System.out.println("Comparing str1 and str2 with .equals() : " + str1.equals(str2));
        System.out.println("Comparing str1 and str3 with == : " + (str1 == str3));
        System.out.println("Comparing str2 and str3 with == : " + (str2 == str3));
        System.out.println("Comparing str3 and str3 with == : " + (str3 == str3));

        /* The '== operator checks if the variables point to the exact same spot in memory, 
         * not just if they have the same text. 
         * - str1 and str2 are false because 'new' creates two completely separate objects in memory.
         * - str1 and str3 are false because str1 is a heap object while str3 is from the String pool.
         * - str2 and str3 are false for the same reason—they live in different memory locations.*/
        
        int[] sharedArray = {1, 2, 3};
        int[] anotherReference = sharedArray;

        System.out.println("Original array: " + sharedArray[0]);
        anotherReference[0] = 99;
        System.out.println("Modified array: " + sharedArray[0]);
        
        
    }




