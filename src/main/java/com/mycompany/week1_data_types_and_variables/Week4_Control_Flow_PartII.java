/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.week1_data_types_and_variables;

/**
 *
 * @author kathe
 */
import java.util.Scanner;

public class Week4_Control_Flow_PartII {

    private static final int CRITICAL_LOW_THRESHOLD = 5;
    private static final int ROWS = 4;
    private static final int SHELVES = 4;

    public static void main(String[] args) {
        System.out.println("==========Number & Square Printer==========");
        
        System.out.println("Number and its Square from 1 to 10:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i + ", Square: " + (i * i));
        }

        System.out.println("\nNumber and its Square from 1 to 20:");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Number: " + i + ", Square: " + (i * i));
        }

        System.out.println();
        sumUntilSentinel();
        System.out.println();
        patternGenerator();
        System.out.println();
        // warehouseInventoryScanner(); // Uncomment to run interactive warehouse inventory
    }

    public static void sumUntilSentinel() {
        System.out.println("==========Sum Until Sentinel Value==========");
        
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        int input;

        System.out.println("Enter integers to sum (enter -1 to stop):");

        while (true) {
            input = scanner.nextInt();

            if (input == -1) {
                break;
            }

            total += input;
        }

        System.out.println("The total sum is: " + total);
        scanner.close();
    }

    public static void patternGenerator() {
        System.out.println("==========Pattern Generator With Early Exit==========");

        int size = 5;
        
        for (int i = 1; i <= size; i++) {
        
            for (int j = 1; j <= size; j++) {
        
                if (i == 5 && j == 2) {
                    continue;
                }
        
                if (j > i) {
                    break;
                }
            
                System.out.print("* ");
            }
            
            System.out.println();
        }
    }

    public static void warehouseInventoryScanner() {
        System.out.println("==========Warehouse Inventory Scanner==========");
        
        int[][] inventory = {
            {10, 20, -1, 5},
            {3, 0, 15, -1},
            {8, -1, 2, 12},
            {-1, 7, 6, 4}
        };

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWarehouse Inventory Menu:");
            System.out.println("1. View Total Inventory");
            System.out.println("2. Find First Critically Low Shelf");
            System.out.println("3. Restock Items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewTotalInventory(inventory);
                    break;
                case 2:
                    findFirstCriticallyLowShelf(inventory);
                    break;
                case 3:
                    restockItems(inventory, scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void viewTotalInventory(int[][] inventory) {
        int total = 0;
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory[i].length; j++) {
                if (inventory[i][j] == -1) {
                    continue;
                }
                total += inventory[i][j];
            }
        }
        System.out.println("Total Inventory (excluding damaged shelves): " + total);
    }

    private static void findFirstCriticallyLowShelf(int[][] inventory) {
        boolean found = false;
        int lowRow = -1, lowCol = -1, lowVal = -1;

        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory[i].length; j++) {
                if (inventory[i][j] != -1 && inventory[i][j] < CRITICAL_LOW_THRESHOLD) {
                    lowRow = i;
                    lowCol = j;
                    lowVal = inventory[i][j];
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (found) {
            System.out.println("First critically low shelf found at (" + lowRow + ", " + lowCol + ") with count: " + lowVal);
        } else {
            System.out.println("No critically low shelves found.");
        }
    }

    private static void restockItems(int[][] inventory, Scanner scanner) {
        int row = -1, col = -1;

        while (row < 0 || row >= ROWS || col < 0 || col >= SHELVES) {
            System.out.print("Enter shelf row (0-" + (ROWS - 1) + "): ");
            row = scanner.nextInt();
            System.out.print("Enter shelf column (0-" + (SHELVES - 1) + "): ");
            col = scanner.nextInt();

            if (row < 0 || row >= ROWS || col < 0 || col >= SHELVES || inventory[row][col] == -1) {
                System.out.println("Invalid or damaged shelf. Please try again.");
                row = -1;
                col = -1;
            }
        }

        System.out.print("Enter amount to restock: ");
        int amount = scanner.nextInt();
        inventory[row][col] += amount;
        System.out.println("Shelf (" + row + ", " + col + ") restocked successfully. New count: " + inventory[row][col]);
    }
}