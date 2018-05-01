package ua.khpi.pinecone.lab3;

public class IteratorPascalTriangle {
    public void buildTriangle(Integer sizeTriangle) {
        for (int i = 0; i < sizeTriangle; i++) {
            int triangleElement = 1;
            System.out.print(triangleElement);
            for (int k = 1; k <= i; k++) {
                triangleElement *= (i - k + 1);
                triangleElement /= k;
                System.out.print(" ");
                System.out.print(triangleElement);
            }
            System.out.println();
        }
    }
}
