// CPSC 2151
// Group Members: Ryan Le, Julio Reyes

package cpsc2150.MyDeque;
import java.util.Scanner;


public class DequeApp {
    public static void main(String args[]){
        IDeque q;
    /*You will add in code here to ask the user whether they want an array implementation or a list implementation.
    Then use their answer to initialize q appropriately*/

        Scanner in = new Scanner(System.in);//initializes scanner variable to check selection
        System.out.println("Please type desired storage type: List or Array. \nPlease type in selection exactly as prompted.");//prompt text
        String userIn = in.next();//sets response to scanner variable

        if(userIn.equals("Array"))//if checks if entry is array
        {
            q = new ArrayDeque();//q initialized as array
        }
        else if(userIn.equals("List"))//if checks if entry is list
        {
            q = new ListDeque();//q initialized as list
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
        //Add the code to print the deque. After the code is finished, the deque
        // should still contain all its values in order


        System.out.println(q);

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
            }
            // ii. Add to the front of the deque
            if (userIn.equals("2")) {
                System.out.println("\nWhat character would you like to add to the front of the deque?");
                userIn = in.next();
                q.inject(userIn.charAt(0));
                System.out.println("\nThe deque is now: " + q);
            }
            // iii. Remove from the front of the deque
            if (userIn.equals("3")) {
                System.out.println("\nRemoving character from front of deque...");
                q.dequeue();
                System.out.println("\nThe deque is now: " + q);
            }
            // iv. Remove from the end of the deque
            if (userIn.equals("4")) {
                System.out.println("\nRemoving character from end of deque...");
                q.removeLast();
                System.out.println("\nThe deque is now: " + q);
            }
            // v. Peek at the front of the deque
            if (userIn.equals("5")) {
                System.out.println("\nThe character at the front of the deque is: " + q.peek());
            }
            // vi. Peek at the end of the deque
            if (userIn.equals("6")) {
                System.out.println("\nThe character at the end of the deque is: " + q.endOfDeque());
            }
            // vii. Insert into a position in the deque
            if (userIn.equals("7")) {
                System.out.println("What position would you like to add your character to?");
                String posChoice = in.next();
                // Setting user position input as an integer
                int posAsInt = Integer.parseInt(posChoice);
                System.out.println("What character would you like to add at this position?");
                userIn = in.next();
                q.insert(userIn.charAt(0), posAsInt);
                System.out.println("\nThe deque is now: " + q);
            }
            // viii. Remove a value from any position in the deque and return it
            if (userIn.equals("8")) {
                System.out.println("What position would you like to remove a character from?");
                String posChoice = in.next();
                // Setting user position input as an integer
                int posAsInt = Integer.parseInt(posChoice);
                q.remove(posAsInt);
                System.out.println("\nThe deque is now: " + q);
            }
            // ix. Peek at a value at any position in the deque
            if (userIn.equals("9")) {
                System.out.println("What position would you like to view in the deque?");
                String posChoice = in.next();
                // Setting user position input as integer
                int posAsInt = Integer.parseInt(posChoice);
                System.out.println("\nThe character at this position is: " + q.get(posAsInt-1));
            }
            // x. Returns the length of the deque
            if (userIn.equals("10")){
                System.out.println("\nThe length of the deque is: " + q.length());
            }
            // xi. Clears the deque
            if (userIn.equals("11")){
                System.out.println("Clearing the deque...");
                q.clear();
                System.out.println("The deque is now empty");
            }
            // xii. Exit
            if (userIn.equals("12")){
                System.out.println("Exiting the program...");
                break;
            }


        }
    }
}