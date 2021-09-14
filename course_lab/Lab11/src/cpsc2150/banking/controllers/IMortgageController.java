// LAB PARTNERS: Julio Reyes, Ryan Le
// DATE: 4/09/2021
// COURSE: CPSC 2151 Lab
// SECTION: 003

package cpsc2150.banking.controllers;

/**
 * This interface is the Controller that partners with IMortgageView
 *
 * Defines:
 *		View: The IMortgageView
 * Initialization ensures: View != NULL
 */

public interface IMortgageController {

    /**
     * This will handle the processing of a mortgage application
     *
     * @pre: none
     * @post: none
     */
    void submitApplication();

}