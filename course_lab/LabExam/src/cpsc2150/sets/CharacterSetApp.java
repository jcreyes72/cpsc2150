package cpsc2150.sets;

import java.util.*;

public class CharacterSetApp {

    private static final int EXIT_CHOICE = 2;
    private static final int MAX_SIZE = 100;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Print a menu of options
        printMenu();
        int input = Integer.parseInt(in.nextLine());
        while (input != EXIT_CHOICE) {
            if (input == 1) {
                //Make each set
                System.out.println("Make set 1");
                ISet<Character> set1 = getSet(in);
                System.out.println("Make set 2");
                ISet<Character> set2 = getSet(in);

                //print the sets
                System.out.println("Set 1 is:");
                System.out.println(set1.toString());
                System.out.println("Set 2 is:");
                System.out.println(set2.toString());

                //get the difference
                set1.difference(set2);

                //print the difference
                System.out.println("The difference is:");
                System.out.println(set1.toString());
            } else {
                System.out.println("That was not an option");
            }

            //print the menu and get the next option
            printMenu();
            input = Integer.parseInt(in.nextLine());
        }
    }

    /**
     * This method will print the options menu
     *
     * @pre none
     * @post [menu will be displayed to user]
     */
    private static void printMenu() {
        System.out.println("\nMake a selection");
        System.out.println("1. Find the DIFFERENCE of Two Sets");
        System.out.println(EXIT_CHOICE + ". Exit");
    }

    /**
     * This method will get the values from a user and build a set
     *
     * @param in a scanner object to use to get data from the user
     * @return a set that the user built
     * @pre in is open and connected to the user
     * @post getSet = [set containing the user provided values]
     */
    private static ISet<Character> getSet(Scanner in) {
        ISet<Character> s;

        System.out.println("Would you like to create a ListSet or an ArraySet? Type 'L' or 'A'");
        String userChoice = in.nextLine();

        if (userChoice.charAt(0) == 'L'){
            s = new ListSet<>();
        }
        else {
            s = new ArraySet<>();
        }


        // add values to the set until user enters "qt" to stop entering values
        System.out.println("Enter a value to add to the set. Enter qt to stop adding to the set");
        String val = in.nextLine();
        while (!val.equals("qt")) {
            //we can assume if they did not enter "qt", they did enter a character
            char addVal = val.charAt(0);

            if (s.getSize() == MAX_SIZE){
                System.out.println("Maximum size has been reached, returning");
                break;
            }

            if (s.contains(val.charAt(0))){
                System.out.println("This value is already in our set, please try another value");
            }
            else {
                s.add(addVal);
            }


            //get the next value before looping
            System.out.println("Enter a value to add to the set. Enter qt to stop adding to the set");
            val = in.nextLine();
        }

        //we have filled our set, so we can return it
        return s;
    }
}