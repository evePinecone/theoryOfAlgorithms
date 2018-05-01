package ua.khpi.pinecone.lab1;

import org.junit.Test;
import ua.khpi.pinecone.lab1.util.ArrayGenerator;
import ua.khpi.pinecone.lab1.util.impl.ArrayGeneratorInteger;

public class SearchTest {

    @Test
    public void searchIn20() {
        System.out.println("Time on 20 elements");
        ArrayGenerator<Integer> arrayGenerator = new ArrayGeneratorInteger();
        Integer[] array = arrayGenerator.getArrayOfNumbers(10, 100, 20);
        Integer elementToSearch = (int)(Math.random()*10);
        long beginLineSearch = System.nanoTime();
        new LineSearchWithBarrier().search(elementToSearch, 20, array);
        long endLineSearch = System.nanoTime();
        System.out.println("Time difference on 20 elements with LineSearch = " + (endLineSearch-beginLineSearch));

        long beginBinarySearch = System.nanoTime();
        new BinarySearch().search(elementToSearch, 20, array);
        long endBinarySearch = System.nanoTime();
        System.out.println("Time difference on 20 elements with BinarySear = " + (endBinarySearch-beginBinarySearch));
        System.out.println("_________________________________________________________________");
    }

    @Test
    public void searchIn100() {
        System.out.println("Time on 100 elements");
        ArrayGenerator<Integer> arrayGenerator = new ArrayGeneratorInteger();
        Integer[] array = arrayGenerator.getArrayOfNumbers(10, 1000, 100);
        Integer elementToSearch = (int)(Math.random()*100);
        long beginLineSearch = System.nanoTime();
        new LineSearchWithBarrier().search(elementToSearch, 100, array);
        long endLineSearch = System.nanoTime();
        System.out.println("Time difference on 100 elements with LineSearch = " + (endLineSearch-beginLineSearch));

        long beginBinarySearch = System.nanoTime();
        new BinarySearch().search(elementToSearch, 20, array);
        long endBinarySearch = System.nanoTime();
        System.out.println("Time difference on 100 elements with BinarySear = " + (endBinarySearch-beginBinarySearch));
        System.out.println("_________________________________________________________________");
    }

    @Test
    public void searchIn1000() {
        System.out.println("Time on 1000 elements");
        ArrayGenerator<Integer> arrayGenerator = new ArrayGeneratorInteger();
        Integer[] array = arrayGenerator.getArrayOfNumbers(10, 10000, 1000);
        Integer elementToSearch = (int)(Math.random()*1000);
        long beginLineSearch = System.nanoTime();
        new LineSearchWithBarrier().search(elementToSearch, 1000, array);
        long endLineSearch = System.nanoTime();
        System.out.println("Time difference on 1000 elements with LineSearch = " + (endLineSearch-beginLineSearch));

        long beginBinarySearch = System.nanoTime();
        new BinarySearch().search(elementToSearch, 1000, array);
        long endBinarySearch = System.nanoTime();
        System.out.println("Time difference on 1000 elements with BinarySear = " + (endBinarySearch-beginBinarySearch));
        System.out.println("_________________________________________________________________");
    }

    @Test
    public void searchIn10000() {
        System.out.println("Time on 10000 elements");
        ArrayGenerator<Integer> arrayGenerator = new ArrayGeneratorInteger();
        Integer[] array = arrayGenerator.getArrayOfNumbers(10, 100000, 10000);
        Integer elementToSearch = (int)(Math.random()*10000);
        long beginLineSearch = System.nanoTime();
        new LineSearchWithBarrier().search(elementToSearch, 10000, array);
        long endLineSearch = System.nanoTime();
        System.out.println("Time difference on 10000 elements with LineSearch = " + (endLineSearch-beginLineSearch));

        long beginBinarySearch = System.nanoTime();
        new BinarySearch().search(elementToSearch, 10000, array);
        long endBinarySearch = System.nanoTime();
        System.out.println("Time difference on 10000 elements with BinarySear = " + (endBinarySearch-beginBinarySearch));
        System.out.println("_________________________________________________________________");
    }
}