package ua.khpi.pinecone.lab3;

public class RecursionPascalTriangle {

    private static long trianglePascal(int i, int j) {
        if (j == 0 || j == i) return 1;
        else return trianglePascal(i - 1, j - 1) + trianglePascal(i - 1, j);
    }

    public void buildTriangle(Integer sizeTriangle) {
        for (int i = 0; i <= sizeTriangle; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(trianglePascal(i, j) + " ");
            }
            System.out.println();
        }
    }
}
