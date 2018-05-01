package ua.khpi.pinecone.lab1.util.impl;

import ua.khpi.pinecone.lab1.util.ArrayGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayGeneratorInteger implements ArrayGenerator<Integer> {

    public Integer[] getArrayOfNumbers(Integer beginNumber, Integer endNumber, int sizeResultArray) {
        Integer[] array = new Integer[sizeResultArray];
        Random random = new Random();
        for(int i = 0; i < sizeResultArray; i++) {
            array[i] = random.nextInt(endNumber - beginNumber + 1) + beginNumber;
        }
        return array;
    }
}
