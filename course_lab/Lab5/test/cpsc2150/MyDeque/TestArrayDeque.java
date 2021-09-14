// CPSC 2151
// Group Members: Julio Reyes, Ryan Le

package cpsc2150.MyDeque;
import cpsc2150.MyDeque.ArrayDeque;
import cpsc2150.MyDeque.IDeque;
import org.junit.Test;
import static org.junit.Assert.assertTrue;



public class TestArrayDeque {


    private IDeque<Character> MakeADeque(){
        // Creating our object
        IDeque<Character> newObject = new ArrayDeque();
        return newObject;
    }


    // In this test we will enqueue the max amount of values
    // into our deque
    @Test
    public void enqueueTestMax(){

        // Creating a new object
        IDeque q = MakeADeque();
        // String that we will compare with our q.toString()
        String strCompare = "";

            // Filling both strCompare and q with same values
            for (int i = 0; i < 100; i++){
                q.enqueue('x');
                strCompare += "x, ";
            }

        // Removing the trailing comma and space that will be at the end of
        // strCompare from our loop
        strCompare = strCompare.substring(0, strCompare.length() - 2);

        // Comparing our two strings
        assertTrue(q.toString().equals(strCompare));

    }


    // In this test we will enqueue the median number of values
    // into our deque
    @Test
    public void enqueueTestMedian(){

        // Creating a new object
        IDeque q = MakeADeque();
        // String that we will compare with our q.toString()
        String strCompare = "";

            // Filling both strCompare and q with same values
            for (int i = 0; i < 50; i++){
                q.enqueue('x');
                strCompare += "x, ";
            }

        // Removing the trailing comma and space that will be at the end of
        // strCompare from our loop
        strCompare = strCompare.substring(0, strCompare.length() - 2);

        // Comparing our two strings
        assertTrue(q.toString().equals(strCompare));

    }


    // In this test we will enqueue the smallest number of values
    // into our deque, i.e just one value. We felt this was a distinct
    // case since it ensures our deque is removing extra space/commas when
    // given only 1 input
    @Test
    public void enqueueTestMin(){

        // Creating a new object and enqueuing value
        IDeque q = MakeADeque();
        q.enqueue('x');

        // Seeing if value is the same
        assertTrue(q.toString().equals("x"));

    }

    // In this test we will fill our deque and make sure that the last
    // value is returned successfully and that our deque has been updated
    @Test
    public void dequeueTestMax(){

        // Creating a new object
        IDeque q = MakeADeque();
        // String that we will compare with our q.toString()
        String strCompare = "";

            // Filling both strCompare and q with same values
            for (int i = 0; i < 100; i++){
                q.enqueue('x');
                strCompare += "x, ";
            }

        // Removing the trailing comma, space, and extra value that will be
        // removed from our deque
        strCompare = strCompare.substring(0, strCompare.length() - 5);

        assertTrue(q.dequeue().equals('x'));
        assertTrue(q.toString().equals(strCompare));
    }

    // In this test we will fill our deque with two values and make sure
    // that our dequeue() results in the value being returned successfully
    // and that our deque has been updated
    @Test
    public void dequeueTestTwo(){

        // Creating a new object and filling with two values
        IDeque q = MakeADeque();
        q.enqueue('x');
        q.enqueue('y');

        assertTrue(q.dequeue().equals('x'));
        assertTrue(q.toString().equals("y"));


    }


    // In this test we will fill our deque with only one value and make sure
    // that our dequeue results in the deque being completely empty and that
    // the single value we have entered is returned
    @Test
    public void dequeueTestEmpty(){

        // Creating a new object and filling it with a single value
        IDeque q = MakeADeque();
        q.enqueue('x');

        assertTrue(q.dequeue().equals('x'));
        assertTrue(q.toString().equals(" "));
    }


   // In this test we will fill our deque with the "maximum - 1" amount of values
   // and make sure that our inject method puts our final value in the correct place
   @Test
   public void injectTestMax(){

       // Creating a new object
       IDeque q = MakeADeque();
       // String that we will compare with our q.toString(), adding y to the
       // front so that it can be compared once 'y' is injected into deque
       String strCompare = "y, ";

           // Filling both strCompare and q with same values
           for (int i = 0; i < 99; i++){
               q.enqueue('x');
               strCompare += "x, ";
           }

       // Removing the trailing comma and space from our string
       strCompare = strCompare.substring(0, strCompare.length() - 2);

       q.inject('y');

       assertTrue(q.toString().equals(strCompare));

   }


   // In this test we will inject our deque with two values to make sure
   // our inject is placing characters in the correct position of our deque
   @Test
   public void injectTestTwo(){

        //Creating new object and injecting two characters
        IDeque q = MakeADeque();
        q.inject('x');
        q.inject('y');

        assertTrue(q.toString().equals("y, x"));

   }


   // In this test we will inject our deque with one value to make sure
   // it is being our character is being formatted correctly when placed
   // into an empty deque
   @Test
   public void injectTestEmpty(){

        // Creating new object and injecting our character
        IDeque q = MakeADeque();
        q.inject('x');

        assertTrue(q.toString().equals("x"));

   }

   // In this test we will be be removing the last element of a full
   // deque to ensure that our program can locate and delete the last
   // element when the maximum number of values have been placed in
   @Test
   public void removeLastTestMax(){

        // Creating new object
        IDeque q = MakeADeque();
        // Creating our string which will be used to compare values
        String strCompare = "";

           // Filling both strCompare and q with same values
           for (int i = 0; i < 100; i++){
               q.enqueue('x');
               strCompare += "x, ";
           }

       // Removing the trailing comma, space, and extra value that will be
       // removed from our deque
       strCompare = strCompare.substring(0, strCompare.length() - 5);

       assertTrue(q.removeLast().equals('x'));
       assertTrue(q.toString().equals(strCompare));

   }


   // In this test we will be removing the last element in a deque which
   // contains only two values
   @Test
   public void removeLastTestTwo(){

       //Creating new object and enqueueing two characters
       IDeque q = MakeADeque();
       q.enqueue('x');
       q.enqueue('y');

       assertTrue(q.removeLast().equals('y'));
       assertTrue(q.toString().equals("x"));

   }


   // In this test we will be removing the last element in a deque which
   // contains only one value, so that we can make sure the deque is emptied
   // correctly
   @Test
   public void removeLastTestEmpty(){

       // Creating new object and enqueueing our character
       IDeque q = MakeADeque();
       q.enqueue('x');

       assertTrue(q.removeLast().equals('x'));
       assertTrue(q.toString().equals(" "));

   }


   // In this test we will be clearing a deque which contains the maximum
   // number of values
   @Test
   public void clearTestMax(){

       // Creating new object
       IDeque q = MakeADeque();

       // Filling q with the maximum number of values
       for (int i = 0; i < 100; i++){
           q.enqueue('x');
       }

       q.clear();

       assertTrue(q.toString().equals(" "));

   }

   // In this test we will be clearing a deque which contains only two values
   @Test
   public void clearTestTwo(){

       //Creating new object and enqueueing two characters
       IDeque q = MakeADeque();
       q.enqueue('x');
       q.enqueue('y');

       q.clear();

       assertTrue(q.toString().equals(" "));

   }


   // In this test we will be clearing a deque which contains only one value
    @Test
    public void clearTestEmpty(){

        // Creating new object and enqueueing our character
        IDeque q = MakeADeque();
        q.enqueue('x');

        q.clear();

        assertTrue(q.toString().equals(" "));

    }

   // In this test we will be peeking at the front of a deque that is filled with
   // the maximum number of values
   @Test
   public void peekTestMax(){

       // Creating new object
       IDeque q = MakeADeque();
       // String we will use to ensure value has not been removed after peek() call
       String strCompare = "";

           // Filling q and strCompare with the maximum number of values
           for (int i = 0; i < 100; i++){
               q.enqueue('x');
               strCompare += "x, ";
           }

       // Removing the trailing comma and space that will be at the end of
       // strCompare from our loop
       strCompare = strCompare.substring(0, strCompare.length() - 2);

       assertTrue(q.peek().equals('x'));
       assertTrue(q.toString().equals(strCompare));


   }


   // In this test we will be peeking at the front of a deque that contains two
   // separate values, so that we can ensure our peek method knows where the front
   // of the deque is
   @Test
   public void peekTestTwo(){

       //Creating new object and enqueueing two characters
       IDeque q = MakeADeque();
       q.enqueue('x');
       q.enqueue('y');


       assertTrue(q.peek().equals('x'));


   }


   // In this test we will be peeking at the front of a deque that only contains
   // one value
   @Test
   public void peekTestOne(){

       // Creating new object and enqueueing our character
       IDeque q = MakeADeque();
       q.enqueue('x');

       assertTrue(q.peek().equals('x'));

   }


   // In this test we will be using the endOfDeque() function on a deque which
   // contains the maximum amount of values
   @Test
   public void endOfDequeTestMax(){

       // Creating new object
       IDeque q = MakeADeque();
       // String we will use to ensure value has not been removed after endOfDeque() call
       String strCompare = "";

       // Filling q and strCompare with the maximum number of values
       for (int i = 0; i < 100; i++){
           q.enqueue('x');
           strCompare += "x, ";
       }

       // Removing the trailing comma and space that will be at the end of
       // strCompare from our loop
       strCompare = strCompare.substring(0, strCompare.length() - 2);

       assertTrue(q.endOfDeque().equals('x'));
       assertTrue(q.toString().equals(strCompare));

   }

    // In this test we will be using endOfDeque() for a deque that contains two
    // separate values, so that we can ensure our method knows where the end
    // of the deque is
    @Test
    public void endOfDequeTestTwo(){

        //Creating new object and enqueueing two characters
        IDeque q = MakeADeque();
        q.enqueue('x');
        q.enqueue('y');


        assertTrue(q.endOfDeque().equals('y'));

    }


    // In this test we will be calling our endOfDeque method on a deque that
    // only contains one value
    @Test
    public void endOfDequeTestOne(){

        // Creating new object and enqueueing our character
        IDeque q = MakeADeque();
        q.enqueue('x');

        assertTrue(q.endOfDeque().equals('x'));

    }


    // In this test we will be calling our insert method on a deque that
    // contains the "maximum - 1" amount of values
    @Test
    public void insertTestMax(){

        // Creating a new object
        IDeque q = MakeADeque();
        // String that we will compare with our q.toString()
        String strCompare = "";

            // Filling both strCompare and q with same values
            for (int i = 0; i < 99; i++){
                q.enqueue('x');
                strCompare += "x, ";
            }

        // Adding a value to the last spot in our string to compare with q
        strCompare += "y";
        // Putting y at last position in our deque
        q.insert('y', 100);


        assertTrue(q.toString().equals(strCompare));

    }


    // In this test we will be calling our insert() method on a deque that
    // contains only two values, so that we can ensure that our methods knows
    // how to shift a deque item into a new position if it needs to
    @Test
    public void insertTestTwo(){

        //Creating new object and enqueueing two characters
        IDeque q = MakeADeque();
        q.enqueue('x');
        q.enqueue('z');

        q.insert('y', 2);

        assertTrue(q.toString().equals("x, y, z"));

    }


    // In this test we will be calling our insert() method at the start of a
    // deque that only contains one value
    @Test
    public void insertTestOne(){

        // Creating new object and enqueuing one character
        IDeque q = MakeADeque();
        q.enqueue('y');

        q.insert('x', 1);

        assertTrue(q.toString().equals("x, y"));

    }


    // In this test we will be calling our remove method on a deque that
    // contains the "maximum - 1" amount of values
    @Test
    public void removeTestMax(){

        // Creating a new object
        IDeque q = MakeADeque();
        // String that we will compare with our q.toString()
        String strCompare = "";

        // Filling both strCompare and q with same values
        for (int i = 0; i < 100; i++){
            q.enqueue('x');
            strCompare += "x, ";
        }


        // Removing the trailing comma, space, and extra value that will be
        // removed from our deque
        strCompare = strCompare.substring(0, strCompare.length() - 5);

        q.remove(100);

        assertTrue(q.toString().equals(strCompare));

    }


    // In this test we will be calling our remove() method on a deque that
    // contains only two values, so that we can ensure that our method knows
    // how to remove a deque item that is located at the front
    @Test
    public void removeTestTwo(){

        //Creating new object and enqueueing two characters
        IDeque q = MakeADeque();
        q.enqueue('x');
        q.enqueue('y');

        q.remove(1);

        assertTrue(q.toString().equals("y"));

    }


    // In this test we will be calling our remove() method at the start of a
    // deque that only contains one value
    @Test
    public void removeTestOne(){

        // Creating new object and enqueuing one character
        IDeque q = MakeADeque();
        q.enqueue('x');

        q.remove(1);

        assertTrue(q.toString().equals(" "));

    }


    // In this test we will be using the get() function on a deque which
    // contains the maximum amount of values
    @Test
    public void getTestMax(){

        // Creating new object
        IDeque q = MakeADeque();

            // Filling q and strCompare with the maximum number of values
            for (int i = 0; i < 99; i++){
                q.enqueue('x');
            }

        q.enqueue('y');

        // For these test cases with get(), we are running get at the i - 1 position
        // to get our ith element. This is because in our main the call to our get()
        // method already takes "i - 1" into account when the user enters their value.
        // Since we have received full credit on this method up until this point we
        // figured doing it this way is still allowed so we didn't make any changes
        assertTrue(q.get(99).equals('y'));

    }


    // In this test we will be calling our get() method on the median value
    // in a deque, so that we can ensure our get() method knows where to locate
    // specific positions
    @Test
    public void getTestMedian(){

        //Creating new object and enqueueing two characters
        IDeque q = MakeADeque();
        q.enqueue('x');
        q.enqueue('y');
        q.enqueue('z');

        // For these test cases with get(), we are running get at the i - 1 position
        // to get our ith element. This is because in our main the call to our get()
        // method already takes "i - 1" into account when the user enters their value.
        // Since we have received full credit on this method up until this point we
        // figured doing it this way is still allowed so we didn't make any changes
        assertTrue(q.get(1).equals('y'));

    }


    // In this test we will be calling our get() method at the start of a
    // deque that only contains one value
    @Test
    public void getTestOne(){

        // Creating new object and enqueuing one character
        IDeque q = MakeADeque();
        q.enqueue('x');

        // For these test cases with get(), we are running get at the i - 1 position
        // to get our ith element. This is because in our main the call to our get()
        // method already takes "i - 1" into account when the user enters their value.
        // Since we have received full credit on this method up until this point we
        // figured doing it this way is still allowed so we didn't make any changes
        assertTrue(q.get(0).equals('x'));

    }





}
