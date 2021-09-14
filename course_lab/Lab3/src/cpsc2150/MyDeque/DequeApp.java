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
        System.out.println("Please type desired storage type: List or Array. \n Please type in selection exactly as prompted.");//prompt text
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

        int arrLength = q.length();

        for(int i = 0; i < arrLength; i++) {
            Character temp = q.dequeue();
            System.out.println("-" + temp + "-");
        }
    }
}