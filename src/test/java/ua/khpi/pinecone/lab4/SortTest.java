package ua.khpi.pinecone.lab4;


import org.junit.Test;
import ua.khpi.pinecone.lab1.util.ArrayGenerator;
import ua.khpi.pinecone.lab1.util.impl.ArrayGeneratorInteger;

import java.util.Arrays;
import java.util.Collections;

public class SortTest {

    private static final int NUMBER_OF_ELEMENTS = 1000;

    @Test
    public void testBubbleSortInjection() {

        ArrayGenerator<Integer> arrayGenerator = new ArrayGeneratorInteger();
        Integer[] array = arrayGenerator.getArrayOfNumbers(10, NUMBER_OF_ELEMENTS * 2, NUMBER_OF_ELEMENTS);
        Integer[] array2 = Arrays.copyOf(array, array.length);
        Arrays.sort(array, Collections.reverseOrder());
        Arrays.sort(array2, Collections.reverseOrder());

        long beginBubbleSort = System.nanoTime();
        new BubbleSortInjection().sort(array);
        long endEndBubbleSort = System.nanoTime();
        System.out.println("Time on " + NUMBER_OF_ELEMENTS + " elements with BubbleSortInjection = " + (endEndBubbleSort - beginBubbleSort) + "\n_____________________________________________");

        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();

        long beginMemorySort = System.nanoTime();
        new BubbleSortPositionInMemory().sort(array2);
        long endMemorySort = System.nanoTime();
        System.out.println("Time on " + NUMBER_OF_ELEMENTS + " elements with BubbleSortPosition memory = " + (endMemorySort - beginMemorySort) + "\n_____________________________________________");
        for (Integer integer : array2) {
            System.out.print(integer + " ");
        }
    }
}