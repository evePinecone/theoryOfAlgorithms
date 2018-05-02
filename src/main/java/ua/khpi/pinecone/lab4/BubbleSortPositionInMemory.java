package ua.khpi.pinecone.lab4;

public class BubbleSortPositionInMemory {

    public void sort(Integer...array) {
        int k = array.length-1;
        Integer position = 0;
        long counterComparing = 0, counterSwaping = 0;
        while (k >= 0) {
            position = 0;
            for(int i = 0; i < k; i++) {
                if(array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    counterSwaping++;
                    position = i+1;
                }
                counterComparing++;
            }
            k = position - 1;
        }
        System.out.println("BubblePositionMemory sort\nNumber of comparing = " + counterComparing + "\nNumber of swap = " + counterSwaping + "\n_____________________________________________");
    }
}
