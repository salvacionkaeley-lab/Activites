/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.week1_data_types_and_variables;

/**
 *
 * @author kathe
 */
import java.util.Arrays;

public class Week5_Arrays {
    public static void main(String[] args) {
        System.out.println("==========Favorite Things Array==========");
        String[] favorites = {"Eating", "Sleeping", "Reading", "Music", "Photography"};

        for (int i = 0; i < favorites.length; i++) {
            System.out.println((i + 1) + ". " + favorites[i]);
        }

        System.out.println("Total number of favorite things: " + favorites.length);
        
        // Call the other mini-tools so they execute when you run this file
        System.out.println();
        StatisticsCalculator.main(args);
        System.out.println();
        SearchAndSortMiniTool.main(args);
        System.out.println();
        ClassRankingSystem.main(args);
    }
}

class StatisticsCalculator {
    public static void main(String[] args) {
        System.out.println("==========Classic Statistics Calculator==========");
        
        int[] scores = {94, 92, 90, 91, 88, 93, 95, 89};

        int sum = 0;
        int highestScore = scores[0];
        int lowestScore = scores[0];

        for (int score : scores) {
            sum += score;

            if (score > highestScore) {
                highestScore = score;
            }

            if (score < lowestScore) {
                lowestScore = score;
            }
        }

        double average = (double) sum / scores.length;

        System.out.println("Sum of scores: " + sum);
        System.out.println("Average score: " + average);
        System.out.println("Highest score: " + highestScore);
        System.out.println("Lowest score: " + lowestScore);
    }
}

class SearchAndSortMiniTool {
    public static void main(String[] args) {
        System.out.println("==========Search and Sort Mini Tool==========");
        
        int[] scores = {85, 92, 76, 88, 90, 100, 67, 78};
        int target = 90;

        int index = linearSearch(scores, target);
        if (index != -1) {
            System.out.println("Target value " + target + " found at index: " + index);
        } else {
            System.out.println("Target value " + target + " not found in the array.");
        }

        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);

        System.out.println("Original array: " + Arrays.toString(scores));
        System.out.println("Sorted array: " + Arrays.toString(sortedScores));
        
        /* Explanation: We make a copy to sort instead of changing the original array, 
           because we might still need the scores in their original order*/
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

class ClassRankingSystem {
    public static void main(String[] args) {
        System.out.println("=========== CLASS RANKING SYSTEM ===========");

        String[][] rawData = {
            {"Kae", "90", "85", "92", "88"},
            {"Avery", "85", "80", "78", "82"},
            {"Saxe", "88", "82", "84", "86"},
            {"Axton", "90", "85", "92", "88"}, 
            {"Scarlett", "75", "70", "72", "78"}
        };

        Student[] list = new Student[rawData.length];
        for (int i = 0; i < rawData.length; i++) {
            String name = rawData[i][0];
            int[] scores = new int[rawData[i].length - 1];
            for (int j = 1; j < rawData[i].length; j++) {
                scores[j - 1] = Integer.parseInt(rawData[i][j]);
            }
            list[i] = new Student(name, scores);
        }

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].average < list[j + 1].average) {
                    Student temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }

        System.out.println("\nLeaderboard:");
        int displayRank = 1;
        for (int i = 0; i < list.length; i++) {
            if (i > 0 && list[i].average != list[i - 1].average) {
                displayRank = i + 1;
            }
            System.out.printf("%d. %s - Average: %.2f%n", displayRank, list[i].name, list[i].average);
            if (i > 0 && list[i].average == list[i - 1].average) {
                System.out.println("    (Tied with " + list[i - 1].name + ")");
            }
        }

        String searchTarget = "Saxe";
        int foundRank = findStudentRank(list, searchTarget);
        System.out.println("\n--- Search Result ---");
        if (foundRank != -1) {
            System.out.println("Rank of " + searchTarget + ": " + foundRank);
        } else {
            System.out.println(searchTarget + " not found.");
        }
    }

    public static int findStudentRank(Student[] list, String targetName) {
        int currentRank = 1;
        for (int i = 0; i < list.length; i++) {
            if (i > 0 && list[i].average != list[i - 1].average) {
                currentRank = i + 1;
            }
            if (list[i].name.equalsIgnoreCase(targetName)) {
                return currentRank;
            }
        }
        return -1;
    }
}

class Student {
    String name;
    int[] quizzes;
    double average;

    public Student(String name, int[] quizzes) {
        this.name = name;
        this.quizzes = quizzes;
        this.average = calculateAverage();
    }

    private double calculateAverage() {
        int sum = 0;
        for (int score : quizzes) {
            sum += score;
        }
        return (double) sum / quizzes.length;
    }
}