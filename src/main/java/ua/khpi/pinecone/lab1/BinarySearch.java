package ua.khpi.pinecone.lab1;

import java.util.Arrays;

public class BinarySearch {
    public int search(Integer element, Integer arrayLength, Integer... array) {
        int counterCompare = 0;
        Arrays.sort(array);
        int i = 0, begin = 0, end = arrayLength-1;
        while (begin < end) {
            i = (begin + end) / 2;
            counterCompare++;
            if (array[i] < element) {
                begin = i + 1;
            } else {
                end = i - 1;
            }
        }
        System.out.println("CounterCompare binarySearch = " + counterCompare);
        if (array[i].equals(element)) {
            return i;
        }
        return -1;
    }
}
