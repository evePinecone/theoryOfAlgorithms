package ua.khpi.pinecone.lab1;

public class LineSearchWithBarrier {
    public int search(Integer element, Integer arrayLength, Integer... array) {
        int i = 0;
        array[arrayLength-1] = element;
        while (!array[i].equals(element)) {
            i++;
        }
        System.out.println("CounterCompare LineSearch = " + i);
        if (i == arrayLength) {
            return -1;
        }
        return i;
    }
}
