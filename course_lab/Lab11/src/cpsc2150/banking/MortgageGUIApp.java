// LAB PARTNERS: Julio Reyes, Ryan Le
// DATE: 4/09/2021
// COURSE: CPSC 2151 Lab
// SECTION: 003

package cpsc2150.banking;
import cpsc2150.banking.controllers.IMortgageController;
import cpsc2150.banking.views.IMortgageView;
import cpsc2150.banking.views.MortgageGUIView;
import cpsc2150.banking.controllers.MortgageGUIController;

public class MortgageGUIApp {

    public static void main(String[] args) {
        IMortgageView view = new MortgageGUIView();
        IMortgageController controller = new MortgageGUIController(view);
        view.setController(controller);
    }

}
