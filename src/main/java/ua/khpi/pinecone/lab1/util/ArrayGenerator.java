package ua.khpi.pinecone.lab1.util;

import java.util.List;

public interface ArrayGenerator<N> {

    N[] getArrayOfNumbers(N beginNumber, N endNumber, int sizeResultArray);
}
