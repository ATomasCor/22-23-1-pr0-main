package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;

import java.lang.reflect.Array;
import java.time.LocalDate;

public class PR0GeometricProgressionArray {
    private int capacity;

    private int[] array;

    public PR0GeometricProgressionArray(int a1, int r, int capacity) {
        this.capacity = capacity;
        array = new int[capacity];


        for (int n=1; n<capacity; n++){
            array[n-1] = a1 * (int) Math.pow(r, (n-1));
        }
    }

    public int[] getArray() {
        return array;
    }

    public int getIndexOf(int value){
        int index = 0;
        for (int v : array) {
            if (v == value) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int binarySearch(int value){
        int prevIndex = 0;
        int index = capacity/2;
        int inf = 0;
        int sup = capacity;

        while(prevIndex != index){
            prevIndex = index;
            if (array[index] == value){
                return index;
            } else if (array[index] > value) {
                sup = index;
                index = (index + inf) / 2;
            } else if (array[index] < value) {
                inf = index;
                index = (index + sup) / 2;
            }
        }
        return -1;
    }
}

