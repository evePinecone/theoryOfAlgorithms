package ua.khpi.pinecone.lab2;

import org.junit.Test;
import ua.khpi.pinecone.lab1.BinarySearch;
import ua.khpi.pinecone.lab1.LineSearchWithBarrier;

import java.util.Random;

public class DirectAccessTableTest {

    public static final int NUMBER_OF_TESTS = 50000;

    @Test
    public void search() {
        DirectAccessTable directAccessTable = new DirectAccessTable();
        Integer[] arrayForLab1Tests = new Integer[NUMBER_OF_TESTS];
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            Integer randomInteger = new Random().nextInt(NUMBER_OF_TESTS * 2);
            directAccessTable.put(new Engine(randomInteger, "qwe" + randomInteger, randomInteger, randomInteger));
            arrayForLab1Tests[i] = randomInteger;
        }
        Integer elementToSearch = new Random().nextInt(NUMBER_OF_TESTS * 2);
        long beginLineSearch = System.nanoTime();
        new LineSearchWithBarrier().search(elementToSearch, NUMBER_OF_TESTS, arrayForLab1Tests);
        long endLineSearch = System.nanoTime();
        System.out.println("" + (endLineSearch-beginLineSearch) + " = time LineSearch (" + NUMBER_OF_TESTS + "ps)");

        long beginBinarySearch = System.nanoTime();
        new BinarySearch().search(elementToSearch, NUMBER_OF_TESTS, arrayForLab1Tests);
        long endBinarySearch = System.nanoTime();
        System.out.println("" + (endBinarySearch-beginBinarySearch) + " = time BinarySearch (" + NUMBER_OF_TESTS + "ps)");

        long beginDirectTableSearch = System.nanoTime();
        directAccessTable.search(elementToSearch);
        long endDirectTableSearch = System.nanoTime();
        System.out.println("No compearing in directSearch");
        System.out.println("" + (endDirectTableSearch-beginDirectTableSearch) + " = time DirectTableSearch (" + NUMBER_OF_TESTS + "ps)");
        System.out.println("_________________________________________________________________");
    }
}