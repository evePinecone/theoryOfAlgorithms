package ua.khpi.pinecone.lab3;

import org.junit.Test;

public class PascalTriangleTest {

    public static final int SIZE_OF_TRIANGLE = 30;

    @Test
    public void comparePascalTriangleAlgo() {
        IteratorPascalTriangle iteratorPascalTriangle = new IteratorPascalTriangle();
        RecursionPascalTriangle recursionPascalTriangle = new RecursionPascalTriangle();

        long beginIterator = System.nanoTime();
        iteratorPascalTriangle.buildTriangle(SIZE_OF_TRIANGLE);
        long endIterator = System.nanoTime();


        long beginRecursion = System.nanoTime();
        recursionPascalTriangle.buildTriangle(SIZE_OF_TRIANGLE);
        long endRecursion = System.nanoTime();
        System.out.println("" + (endIterator-beginIterator) + " = time Iterator algorithm for (" + SIZE_OF_TRIANGLE + " size)");
        System.out.println("" + (endRecursion-beginRecursion) + " = time Recursion algorithm for (" + SIZE_OF_TRIANGLE + " size)");
    }
}