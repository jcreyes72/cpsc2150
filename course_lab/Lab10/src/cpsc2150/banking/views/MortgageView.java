package cpsc2150.banking.views;
import java.util.Scanner;

import cpsc2150.banking.models.IMortgage;
import cpsc2150.banking.controllers.IMortgageController;

public class MortgageView implements IMortgageView {

    // CLASS LEVEL VARIABLES
    // We wont use this IMortgageController object but it is
    // required by the initialization ensures clause
    IMortgageController voidObject;
    // Initialize scanner variable to get user input
    Scanner in = new Scanner(System.in);


    // Setting our IMortgageController variable using argument provided
    @Override
    public void setController(IMortgageController c) {
        voidObject = c;
    }

    @Override
    public double getHouseCost() {

        System.out.println("How much does the house cost");
        // Scanning for double
        double houseCost = in.nextDouble();
        // Moving on...
        in.nextLine();

        return houseCost;
    }

    @Override
    public double getDownPayment() {

        System.out.println("How much is the down payment?");
        // Scanning for double
        double downPayment = in.nextDouble();
        // Moving on...
        in.nextLine();

        return downPayment;

    }


    @Override
    public int getYears() {

        System.out.println("How many years ?");
        // Scanning for int
        int yrs = in.nextInt();
        // Moving on...
        in.nextLine();

        return yrs;

    }

    @Override
    public double getMonthlyDebt() {

        System.out.println("How much are your monthly debt payments?");
        // Scanning for double
        double monthlyDebtPayment = in.nextDouble();
        // Moving on...
        in.nextLine();

        return monthlyDebtPayment;

    }


    @Override
    public double getYearlyIncome() {

        System.out.println("How much is your yearly income?");
        // Scanning for double
        double yearlyIncome = in.nextDouble();
        // Moving on...
        in.nextLine();

        return yearlyIncome;

    }

    @Override
    public int getCreditScore() {

        System.out.println("What is the credit score?");
        // Scanning for int
        int creditScore = in.nextInt();
        // Moving on...
        in.nextLine();

        return creditScore;

    }

    @Override
    public String getName() {

        System.out.println("What's your name");
        return in.nextLine();

    }

    @Override
    public void printToUser(String s) {
        // Simply output message to screen
        System.out.println(s);
    }

    @Override
    public void displayPayment(double p) {
        System.out.println("Principal Amount: $" + p);
    }

    @Override
    public void displayRate(double r) {
        System.out.println("Interest Rate: " + r + "%");
    }

    @Override
    public void displayApproved(boolean a) {
        System.out.println(a);
    }

    @Override
    public boolean getAnotherMortgage() {

        System.out.println("Would you like to apply for another mortgage? Y/N");
        // Scanning for Y or y or N or n
        char input = in.next().toUpperCase().charAt(0);
        in.nextLine();
        // True or false depending on user input
        return input == 'Y';

    }

    @Override
    public boolean getAnotherCustomer() {

        System.out.println("Would you like to consider another customer Y/N");
        // Scanning for Y or y or N or n
        char input = in.next().toUpperCase().charAt(0);
        in.nextLine();
        // True or false depending on user input
        return input == 'Y';

    }

}