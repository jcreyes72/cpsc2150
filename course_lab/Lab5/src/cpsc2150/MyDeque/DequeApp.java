// CPSC 2151
// Group Members: Julio Reyes, Ryan Le

package cpsc2150.MyDeque;
import java.util.Scanner;


public class DequeApp {
    public static void main(String args[]){
        IDeque q;

        // Initializes scanner variable to check selection
        Scanner in = new Scanner(System.in);
        // Prompt text
        System.out.println("Please type desired storage type: List or Array. \nPlease type in selection exactly as prompted.");
        // Sets response to scanner variable
        String userIn = in.next();

        if(userIn.equals("Array")) // Check if entry is Array
        {
            q = new ArrayDeque();  // q initialized as Array
        }
        else if(userIn.equals("List")) // Checks if entry is List
        {
            q = new ListDeque(); // q initialized as List
        }else//no other acceptable answers, so error prompt
        {
            System.out.println("Please re-enter your desired storage type exactly as indicated.");//error prompt
            return;//exits program
        }
        Character x = 'a';
        q.enqueue(x);
        x = 'k';
        q.enqueue(x);
        x = 'j';
        q.enqueue(x);
        x = '1';
        q.enqueue(x);
        x = 'f';
        q.enqueue(x);

        // Deque is printed out to the screen
        System.out.println(q);

        // Loop until user chooses to exit
        while (true) {

            // Displaying menu for user to edit deque
            System.out.println("\nMENU:\n" + "" +
                    "i. Add to the end of the deque\n" +
                    "ii. Add to the front of the deque\n" +
                    "iii. Remove from the front of the deque\n" +
                    "iv. Remove from the end of the deque\n" +
                    "v. Peek at the front of the deque\n" +
                    "vi. Peek at the end of the deque\n" +
                    "vii. Insert into a position in the deque\n" +
                    "viii. Remove a value from any position in the deque and return it\n" +
                    "ix. Peek at a value at any position in the deque\n" +
                    "x. Returns the length of the deque\n" +
                    "xi. Clears the deque\n" +
                    "xii. Exit\n");

            // Getting input from scanner
            userIn = in.next();

            // OPTIONS
            // i. Add to the end of the deque
            if (userIn.equals("1")) {
                System.out.println("\nWhat character would you like to add to the end of the deque?");
                userIn = in.next();
                q.enqueue(userIn.charAt(0));
                System.out.println("\nThe deque is now: " + q);
                continue;
            }
            // ii. Add to the front of the deque
            else if (userIn.equals("2")) {
                System.out.println("\nWhat character would you like to add to the front of the deque?");
                userIn = in.next();
                q.inject(userIn.charAt(0));
                System.out.println("\nThe deque is now: " + q);
                continue;
            }
            // iii. Remove from the front of the deque
            else if (userIn.equals("3")) {
                // In case deque is empty
                if (q.length() == 0){
                    System.out.println("\nThe deque is empty!");
                }
                else {
                    System.out.println("\nRemoving character from front of deque...");
                    q.dequeue();
                    System.out.println("\nThe deque is now: " + q);
                }
                continue;
            }
            // iv. Remove from the end of the deque
            else if (userIn.equals("4")) {
                // In case deque is empty
                if (q.length() == 0){
                    System.out.println("\nThe deque is empty!");
                }
                else {
                    System.out.println("\nRemoving character from end of deque...");
                    q.removeLast();
                    System.out.println("\nThe deque is now: " + q);
                }
                continue;
            }
            // v. Peek at the front of the deque
            else if (userIn.equals("5")) {
                // In case deque is empty
                if (q.length() == 0){
                    System.out.println("\nThe deque is empty!");
                }
                else {
                    System.out.println("\nThe character at the front of the deque is: " + q.peek());
                }
                continue;
            }
            // vi. Peek at the end of the deque
            else if (userIn.equals("6")) {
                // In case deque is empty
                if (q.length() == 0){
                    System.out.println("\nThe deque is empty!");
                }
                else {
                    System.out.println("\nThe character at the end of the deque is: " + q.endOfDeque());
                }
                continue;
            }
            // vii. Insert into a position in the deque
            else if (userIn.equals("7")) {
                System.out.println("What position would you like to add your character to?");
                String posChoice = in.next();
                // Setting user position input as an integer
                int posAsInt = Integer.parseInt(posChoice);
                System.out.println("What character would you like to add at this position?");
                userIn = in.next();
                q.insert(userIn.charAt(0), posAsInt);
                System.out.println("\nThe deque is now: " + q);
                continue;
            }
            // viii. Remove a value from any position in the deque and return it
            else if (userIn.equals("8")) {
                // In case deque is empty
                if (q.length() == 0){
                    System.out.println("\nThe deque is empty!");
                }
                else {
                    System.out.println("What position would you like to remove a character from?");
                    String posChoice = in.next();
                    // Setting user position input as an integer
                    int posAsInt = Integer.parseInt(posChoice);
                    System.out.println("\nYou have removed the value: " + q.remove(posAsInt));
                    System.out.println("The deque is now: " + q);
                }
                continue;
            }
            // ix. Peek at a value at any position in the deque
            else if (userIn.equals("9")) {
                // In case deque is empty
                if (q.length() == 0){
                    System.out.println("\nThe deque is empty!");
                }
                else {
                    System.out.println("What position would you like to view in the deque?");
                    String posChoice = in.next();
                    // Setting user position input as integer
                    int posAsInt = Integer.parseInt(posChoice);
                    System.out.println("\nThe character at this position is: " + q.get(posAsInt - 1));
                }
                continue;
            }
            // x. Returns the length of the deque
            else if (userIn.equals("10")){
                // In case deque is empty
                if (q.length() == 0){
                    System.out.println("\nThe deque is empty!");
                }
                else {
                    System.out.println("\nThe length of the deque is: " + q.length());
                }
                continue;
            }
            // xi. Clears the deque
            else if (userIn.equals("11")){
                // In case deque is empty
                if (q.length() == 0){
                    System.out.println("\nThe deque is already empty!");
                }
                else {
                    System.out.println("Clearing the deque...");
                    q.clear();
                    System.out.println("The deque is now empty");
                }
                continue;
            }
            // xii. Exit
            else if (userIn.equals("12")){
                System.out.println("Exiting the program...");
                break;
            }
            else {
                System.out.println("\nPlease enter a number from 1-12 to select a specific menu option");
                continue;
            }
        }
    }
}