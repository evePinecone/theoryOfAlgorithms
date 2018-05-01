package ua.khpi.pinecone.lab4;


import org.junit.Test;
import ua.khpi.pinecone.lab1.util.ArrayGenerator;
import ua.khpi.pinecone.lab1.util.impl.ArrayGeneratorInteger;

import java.util.Arrays;
import java.util.Collections;

public class SortTest {

    private static final int NUMBER_OF_ELEMENTS = 50000;

    @Test
    public void testBubbleSortInjection() {

        ArrayGenerator<Integer> arrayGenerator = new ArrayGeneratorInteger();
        Integer[] array = arrayGenerator.getArrayOfNumbers(10, NUMBER_OF_ELEMENTS * 2, NUMBER_OF_ELEMENTS);
        Arrays.sort(array, Collections.reverseOrder());

        long beginBubbleSort = System.nanoTime();
        new BubbleSortInjection().sort(array);
        long endEndBubbleSort = System.nanoTime();
        System.out.println("Time on " + NUMBER_OF_ELEMENTS + " elements with BubbleSortInjection = " + (endEndBubbleSort-beginBubbleSort));

        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}