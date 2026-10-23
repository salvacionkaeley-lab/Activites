/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.week1_data_types_and_variables;

/**
 *
 * @author kathe
 */
public class Week2_Java_Operators {
    
        public static void main(String[] args) {
        System.out.println("==========Four-Function Calculator==========");
        int num1 = 15;
        int num2 = 4;

        System.out.println("Addition (+): " + (num1 + num2));
        System.out.println("Subtraction (-): " + (num1 - num2));
        System.out.println("Multiplication (*): " + (num1 * num2));
        System.out.println("Division (/): " + (num1 / num2));
        System.out.println("Modulo/Remainder (%): " + (num1 % num2));

        /* EXPLANATION: The modulo operator (%) behaves differently with negative operands because 
        the result takes the sign of the dividend (the first operand). 
        For example, -15 % 4 gives -3, while 15 % -4 gives 3. */

        System.out.println();
        gradeThresholdChecker();
        System.out.println();
        compoundGrowthTracker();
        System.out.println();
        precedencePuzzleSolver();
    }

    public static void gradeThresholdChecker() {
        System.out.println("==========Grade Threshold Checker==========");
        System.out.println("==========Grade Threshold Checker==========");
        double averageGrade = 90.5;
        int absences = 0;

        boolean isEligible = (averageGrade >= 75 && absences <= 3) || (averageGrade >= 90);

        System.out.println("=== Grade Threshold Evaluation ===");
        System.out.println("Average Grade: " + averageGrade);
        System.out.println("Absences:      " + absences);
        
        if (isEligible) {
            System.out.println("Result: PASS");
            System.out.println("Reasoning: The student meets the eligibility criteria.");
        } else {
            System.out.println("Result: FAIL");
            System.out.println("Reasoning: The student does not meet the eligibility criteria.");
        }
    }

    public static void compoundGrowthTracker() {
        System.out.println("==========Compound Growth and Increment Tracker==========");
        
        double balance = 5000.0;
        System.out.println("Initial Balance: " + balance);

        /* Step 1: Add deposit */
        balance += 200;
        System.out.println("Balance after += 200: " + balance);
        
        /* Step 2: Apply 5% interest */
        balance *= 1.05;
        System.out.println("Balance after *= 1.05: " + balance);
        
        /* Step 3: Add bonus */
        balance += 150;
        System.out.println("Balance after += 150: " + balance);

        int count = 0;
        System.out.println("Postfix Increment: " + count++);
        System.out.println("Count after postfix increment: " + count); 

        count = 0;
        System.out.println("Prefix Increment: " + ++count);
        System.out.println("Count after prefix increment: " + count);

        /* EXPLANATION:
         - Postfix (count++): Uses the current value first inside the print statement, 
           then increases it afterward. That's why it printed 5 before becoming 6.
         - Prefix (++count): Increases the value first, then uses the updated value 
           in the print statement. That's why it printed 6 immediately.
         */
    }

    public static void precedencePuzzleSolver() {
        System.out.println("==========Precedence Puzzle Solver==========");
        
        /* Expression 1
         *  Predicted result: 1 (because 5 > 3 is true, which is 1 in Java)
         *  Actual result: 7 */
        int result1 = (5 > 3 ? 1 : 0) + 2 * 3;
        System.out.println("Expression 1 Result: " + result1);
        /* Follow-up: I forgot that multiplication has higher priority than addition and the ternary operator, 
           so it did the multiplication first. */

        /* Expression 2
         *  Predicted result: 0 (because 5 < 3 is false, which is 0 in Java)
         *  Actual result: 0 */
        int result2 = ((5 < 3 ? 1 : 0) == 0 && 2 > 1) ? 1 : 0;
        System.out.println("Expression 2 Result: " + result2); 
        /* Follow-up: because (5 < 3 ? 1 : 0) resulted in 0, but then the check `== 0` turned it into true. 
           That made the whole expression true, so the outer ternary gave us 1 instead of 0 */
        
        /* Expression 3
        // Predicted result: 4 (because 5 - 1 is 4) */
        int a = 5;
        int result3 = a-- - 1 + ++a;
        System.out.println("Expression 3 Result: " + result3); // Actual result: 5

        /* Follow-up: I forgot that increment and decrement operators modify 
           the variable right in the middle of the expression, causing 'a' to change mid-calculation. */
    }
}