package cpsc2150.sets;

import java.lang.reflect.Array;

public class ArraySet <T> extends SetAbs <T> implements ISet<T>{

    private final T[] ourSet;
    private int size;


    public ArraySet(){

        ourSet = (T[]) new Object[MAX_SIZE];
        size = 0;
    }


    @Override
    public void add(T val) {

        ourSet[size] = val;
        size++;

    }

    @Override
    public T remove() {

        // Value we are removing
        T chuckValue = ourSet[0];

            // Looping through array to fix our size
            for (int i = 0; i < size - 1; i++){
                ourSet[i] = ourSet[i+1];
            }

        // Editing size
        size = size - 1;

        return chuckValue;
    }

    @Override
    public boolean contains(T val) {

        for(int i = 0; i < size; i++){
            if(ourSet[i].equals(val)){
                return true;
            }
        }

        return false;
    }

    @Override
    public int getSize() {
        return size;
    }
}
