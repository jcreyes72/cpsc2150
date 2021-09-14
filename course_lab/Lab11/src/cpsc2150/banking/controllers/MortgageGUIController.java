package cpsc2150.banking.controllers;

import cpsc2150.banking.models.Customer;
import cpsc2150.banking.models.ICustomer;
import cpsc2150.banking.models.IMortgage;
import cpsc2150.banking.models.Mortgage;
// LAB PARTNERS: Julio Reyes, Ryan Le
// DATE: 4/09/2021
// COURSE: CPSC 2151 Lab
// SECTION: 003

import cpsc2150.banking.views.IMortgageView;

public class MortgageGUIController implements IMortgageController {

    private IMortgageView view;
    // The highest credit score we can have
    int CREDIT_MAX = 850;


    public MortgageGUIController(IMortgageView v){
        view = v;
    }

    public void submitApplication() {

        // boolean which will tracks errors we may have, no errors at initialization
        // so it is currently false
        boolean errorsFound = false;

            // Ensuring that our method runs don't result in error
            try {
                view.getYearlyIncome();
                view.getMonthlyDebt();
                view.getCreditScore();
                view.getHouseCost();
                view.getDownPayment();
            }
            catch(Exception e) {
                view.printToUser("Please fill out every box");
                errorsFound = true;
            }

            if(!errorsFound) {
                // Errors messages depending on what the user has done wrong
                if (view.getName().isEmpty()) {
                    view.printToUser("Please enter a name.");
                }
                else if (view.getYearlyIncome() <= 0) {
                    view.printToUser("Income needs to be greater than 0");
                }
                else if (view.getMonthlyDebt() < 0) {
                    view.printToUser("Debt needs to be greater than or equal to 0.");
                }
                else if (view.getCreditScore() <= 0 || view.getCreditScore() >= CREDIT_MAX) {
                    view.printToUser("Credit Score needs to be greater than 0 and less than 850");
                }
                else if (view.getHouseCost() <= 0) {
                    view.printToUser("Cost needs to be greater than 0.");
                }
                else if (view.getDownPayment() <= 0 || view.getDownPayment() >= view.getHouseCost()) {
                    view.printToUser("Down Payment needs to be greater than 0 and less than the cost of the house.");
                }
                else {

                    ICustomer ourCustomer;
                    ourCustomer = new Customer(view.getMonthlyDebt(), view.getYearlyIncome(), view.getCreditScore(), view.getName());

                    IMortgage ourMortgage;
                    ourMortgage = new Mortgage(view.getHouseCost(), view.getDownPayment(), view.getYears(), ourCustomer);


                    // If our loan gets approved...
                    if (ourMortgage.loanApproved()) {

                        view.displayApproved(true);
                        view.displayRate(ourMortgage.getRate());
                        view.displayPayment(ourMortgage.getPayment());

                    }
                    // Otherwise...
                    else {
                        view.displayApproved(false);
                        view.displayRate(0);
                        view.displayPayment(0);
                    }
                }
            }


    }
}
