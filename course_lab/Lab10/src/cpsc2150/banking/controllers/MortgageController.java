package cpsc2150.banking.controllers;

import cpsc2150.banking.models.Customer;
import cpsc2150.banking.models.IMortgage;
import cpsc2150.banking.views.IMortgageView;

public class MortgageController implements IMortgageController {

    // This constant will ensure we do not exceed the maximum amount for credit score
    int CREDIT_MAX = 850;

    // Our private view variable we will use to utilize our view
    private IMortgageView ourView;
    // The cost of our house, monthly debt payment, income, and down payment (in that order)
    double houseCost, monthlyDebtPayment, income, downPayment;
    // Our credit score and years
    int creditScore, yrs;
    // Name for user
    String name;




    public MortgageController(IMortgageView view){
        ourView = view;
    }


    @Override
    public void submitApplication() {

        ourView.printToUser("What's your name?");


    }
}
