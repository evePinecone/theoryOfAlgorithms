package ua.khpi.pinecone.lab6;

public class ActionsWithMatrix {

    private double[][] A = {{1.2, -2, 0.2}, {0.5, 2.1, 1.3}, {-9, 0.7, 5.6}};
    private double[][] B = {{1.32, 1.3, 0.3}, {0.2, 0.7, 5.6}, {1.3, 0.3, 0.5}};


    public double[][] addingByModulo() {
        System.out.println("mod(A+B,4)");
        double[][] K = new double[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                K[i][j] = mod((A[i][j] + B[i][j]) % 4);
                System.out.printf("%6.2f ", K[i][j]);
            }
            System.out.println();
        }
        return K;
    }

    public double[][] multByModulo() {
        System.out.println("mod(A*B,4)");
        double[][] K = new double[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    K[i][j] += A[i][k] * B[k][j];
                }
                K[i][j] = mod(K[i][j]);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%6.2f ", K[i][j]);
            }
            System.out.println();
        }
        return K;
    }

    private static double mod(double x) {
        while (x < 0) {
            x += 4;
        }
        while (x > 4) {
            x -= 4;
        }
        return x;
    }

    public static void main(String[] args) {
        ActionsWithMatrix actions = new ActionsWithMatrix();
        actions.addingByModulo();
        actions.multByModulo();
    }
}
