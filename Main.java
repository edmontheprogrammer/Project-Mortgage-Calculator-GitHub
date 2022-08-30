import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 * Method for Solving Problems: 
    * Step 1: Understand the Problem: 
        * Create a Mortgage Calculator so when the user run 
        the program they'll get prompt with the following inputs, 
         questions:
         1. Enter Principal (Amount of Loan the user wants to get, 
            money, example, $10000): 
         2. Enter Annual Interest Rate (example, 3.92% percent)    
         3. Enter Period (In years, 30 years for example)
        * The program should take the inputs and display the mortage, 
            monthly payment as a currency.

         // Inputs: What are the inputs for? What kind of inputs will 
         go into this problem? 
         // Inputs: (principal, 10000), (interest rate, 3.92), 
                    (period, 30)
        
        // Outputs: What are the outputs? What will this function return?
        // Outputs: (Mortage, $472.81)

        // What's an example input?
           mortageCalculator(10000, 3.92, 30)

        // What's an example output? 
             mortageCalculator(10000, 3.92, 30) ---> $472.81
    
        * Step 2: Create a Plan in Pseudocode and Instructions for How
              You'll Solve the Prolem in Plain English. 

              // Create a function that returns a double floating point data type
              // The function should have have three input parametersPrincipal, 
              // annualInterestRate and periodInYears
              // Create a variable named mortage to calculate mortage
              // The return value of the method should be the mortage amount

            // Create a reference variable to the "Scanner()" class object and 
             // use it to read three inputs from the user 

              // Research the Mortage Formula and assign it to the 
              // "mortage" variable 
             // M = p (r(1 + r)^n)/ ((1 + r)^n - 1)
             // * M is your monthly payment 
             // * P is your principal 
             // * r is your monthly interest rate, calculated by dividing 
             // your annual interest rate by 12. 
             // * n is your number of payments (the number of months 
             // you will be paying the loan)  

           

             // class the mortageCalculator method in main()


    * Step 3: Implement the Plan in Code (Solve the Problem)

    * Step 4: Look Back and Make Revisions of How You SOlved the 
               Problem
*/
public class Main {

    public static void main(String[] args) {
        System.out.println("Calculating Mortage Payments ");

        MortageCalculator mc = new MortageCalculator();
        double mortage = mc.mortageCalculator();
        System.out.println(mortage);
    }

}

class MortageCalculator {
    final byte MONTHS_IN_YEARS = 12;
    final byte PERECENT = 100;

    // * Step 3: Implement the Plan in Code (Solve the Problem)
    public double mortageCalculator() {
        Scanner scanner = new Scanner(System.in);
        int principal = 0;
        while (true) {
            System.out.print("Enter Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1,000,000");
        }

        System.out.print("Enter Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterest = annualInterestRate / PERECENT / MONTHS_IN_YEARS;

        System.out.print("Enter Period (Number of Years): ");
        int period = scanner.nextInt();

        int numberOfMonthsForLoanRepayments = MONTHS_IN_YEARS * period;

        // Research the Mortage Formula and assign it to the
        // "mortage" variable
        // M = p (r(1 + r)^n)/ ((1 + r)^n - 1)
        // * M is your monthly payment
        // * P is your principal
        // * r is your monthly interest rate, calculated by dividing
        // your annual interest rate by 12.
        // * n is your number of payments (the number of months
        // you will be paying the loan)
        // double r = annualInterestRate / 12;
        // double n = period * 12;

        double mortage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfMonthsForLoanRepayments))
                / (Math.pow(1 + monthlyInterest, numberOfMonthsForLoanRepayments) - 1);

        // System.out.println(principal);
        // System.out.println(annualInterestRate);
        // System.out.println(period);

        // System.out.println("Mortage = $" + Math.round(mortage));
        scanner.close();
        return mortage;
    }

}