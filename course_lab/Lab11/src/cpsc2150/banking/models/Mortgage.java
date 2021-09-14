// LAB PARTNERS: Julio Reyes, Ryan Le
// DATE: 4/09/2021
// COURSE: CPSC 2151 Lab
// SECTION: 003

package cpsc2150.banking.models;

public class Mortgage extends AbsMortgage implements IMortgage{


    private double monthlyPayment;
    private double monthlyRate;
    private double debtToIncomeRatio;
    private double principal;
    private double percentDown;
    private int numPayments;
    private int years;
    private double baseAPR;



    public Mortgage(double houseCost, double downPayment, int yrs, ICustomer cust){

        // Getting the values for our mortgage variables
        years = yrs;
        principal = houseCost - downPayment;
        percentDown = downPayment / houseCost;
        baseAPR = BASERATE;
        numPayments = years * MONTHS_IN_YEAR;


        // If loan is less than 30 years, add 0.5% to APR. 1% otherwise
        if (years < MAX_YEARS){
            baseAPR = baseAPR + GOODRATEADD;
        }
        else {
            baseAPR = baseAPR + NORMALRATEADD;
        }

        // If percent down is not at least 20%, add 0.5% to APR
        if (percentDown < PREFERRED_PERCENT_DOWN){
            baseAPR = baseAPR + GOODRATEADD;
        }


        // Adding to APR based on customer credit score

        // VERY BAD
        if (cust.getCreditScore() <= BADCREDIT){
            baseAPR = baseAPR + VERYBADRATEADD;
        }
        // BAD
        if (cust.getCreditScore() >= BADCREDIT && cust.getCreditScore() <= FAIRCREDIT){
            baseAPR = baseAPR + BADRATEADD;
        }
        // FAIR
        if (cust.getCreditScore() >= FAIRCREDIT && cust.getCreditScore() <= GOODCREDIT){
            baseAPR = baseAPR + NORMALRATEADD;
        }
        // GOOD
        if (cust.getCreditScore() >= GOODCREDIT && cust.getCreditScore() <= GREATCREDIT){
            baseAPR = baseAPR + GOODRATEADD;
        }


        // Computing our monthly interest rate now that we have determined our APR
        monthlyRate = baseAPR/MONTHS_IN_YEAR;
        // Computing our monthly payments now that we have determined our rate
        monthlyPayment = (monthlyRate * principal) / (1 - Math.pow(1 + monthlyRate, - numPayments));
        // Computing our debt to income ratio now that we have determined our monthly payment
        debtToIncomeRatio = (cust.getMonthlyDebtPayments()) / (cust.getIncome()/MONTHS_IN_YEAR);

    }


    @Override
    public boolean loanApproved() {

        // Reject loan if APR is greater than or equal to 10%, percentDown less than .035, or DToI is less than or equal to .4
        if ((baseAPR >= RATETOOHIGH)||(percentDown<MIN_PERCENT_DOWN)||(debtToIncomeRatio>=DTOITOOHIGH)){
            return false;
        }
        return true;
    }

    @Override
    public double getPayment() {
        return monthlyPayment;
    }

    @Override
    public double getRate() {
        return baseAPR;
    }

    @Override
    public double getPrincipal() {
        return principal;
    }

    @Override
    public int getYears() {
        return years;
    }
}
