// CPSC 2151
// Group Members: Julio Reyes, Ryan Le

package cpsc2150.listDec;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public interface IShuffleList<T> extends List<T> {

    /**
     * We were unsure if the interface required this contract but decided to add it
     * just to be safe.
     *
     * Defines: Num_Swaps: Z - The number of swaps our shuffle will make to our list
     *          Element_One: Z - The first element we will swap with our second
     *          Element_Two: Z - The second element that will be swapped with our first
     *
     * Constraints: 0 <= Element_One < List.size()
     *              0 <= Element_Two < List.size()
     *
     */


    /**
     * This method swaps two random elements that are inside our list
     * @param swaps The number of swaps that will be performed on our list
     * @pre Elements swapped must be within list size (i.e 0 <= posOne < this.size())
     * @post List members will be swapped at random "swaps" amount of times
     * @return Void
     */
    default void shuffle (int swaps){

        // rand we will use to generate random numbers
        Random rand = new Random();
        // This upperBound will keep us from generating random numbers larger than our List size
        int upperBound = this.size();

        // Loop through "swaps" amount of times, swapping random list elements
        for (int i = 0; i < swaps; i++){
            // Our two positions we will swap
            int posOne = rand.nextInt(upperBound);
            int posTwo = rand.nextInt(upperBound);
            swap(posOne, posTwo);
        }

    }

    /**
     * This method swaps two specified elements in our list
     * @param i Our first element which will be swapped with j
     * @param j Our second element which will be swapped with i
     * @pre 0 <= i < this.size(); 0 <= j < this.size()
     * @post Element i and j in our list will be swapped with one another
     * @return Void
     */
    default void swap (int i, int j){

        Collections.swap(this, i, j);

    }


}
