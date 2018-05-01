package ua.khpi.pinecone.lab4;

public class BubbleSortInjection {
    void sort(Integer... array) {
        int i = 1;
        long counterComparing = 0, counterSwaping = 0;
        while (i < array.length) {
            counterComparing++;
            if (i == 0 || array[i - 1] <= array[i])
                i++;
            else {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                counterSwaping++;
                i--;
            }
        }
        System.out.println("Bubble sort\nNumber of comparing = " + counterComparing + "\nNumber of swap = " + counterSwaping + "\n_____________________________________________");
    }
}
