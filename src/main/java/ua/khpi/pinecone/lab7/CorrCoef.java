package ua.khpi.pinecone.lab7;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class CorrCoef {

    private static final Integer n = 4;
    private BigDecimal[][] V;

    private void generateMatrix() {
        V = new BigDecimal[30][5];
        for (int i = 0; i < 30; i++) {
            V[i][0] = (new BigDecimal(-1)).pow(i).add(new BigDecimal(i * n));
            V[i][1] = (new BigDecimal(i).pow(n).add(new BigDecimal(-i).pow(n)));
            V[i][2] = (new BigDecimal(-n).pow(i+n)).add(new BigDecimal(i));
            if (n - i < 0) {
                V[i][3] = (new BigDecimal(1)).divide(new BigDecimal(-i).pow(Math.abs(n-i)),10,RoundingMode.HALF_UP).add(new BigDecimal(i));
            } else {
                V[i][3] = (new BigDecimal(-i).pow(n-i)).add(new BigDecimal(i));
            }
            if (i-n < 0) {
                V[i][4] = (new BigDecimal(1)).divide(new BigDecimal(i-n).pow(Math.abs(i-n)),10, RoundingMode.HALF_UP).add(new BigDecimal(i));
            } else {
                V[i][4] = (new BigDecimal(-n).pow(i-n)).add(new BigDecimal(i));
            }
        }
    }

    private BigDecimal[][] corrCoef() {
        BigDecimal[][] resultMatrix = new BigDecimal[5][5];
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                BigDecimal sumOfXiYi = new BigDecimal(0);
                BigDecimal sumOfXi = new BigDecimal(0);
                BigDecimal sumOfYi = new BigDecimal(0);
                BigDecimal sumOfXipow = new BigDecimal(0);
                BigDecimal sumOfYipow = new BigDecimal(0);
                for (int i = 0; i < 30; i++) {
                    sumOfXiYi = sumOfXiYi.add(V[i][x].multiply(V[i][y]));
                    sumOfXi = sumOfXi.add(V[i][x]);
                    sumOfXipow = sumOfXipow.add(V[i][x].pow(2));
                    sumOfYi = sumOfYi.add(V[i][y]);
                    sumOfYipow = sumOfYipow.add(V[i][y].pow(2));
                }
                BigDecimal numerator = (new BigDecimal(30)).multiply(sumOfXiYi).subtract(sumOfXi.multiply(sumOfYi));
                BigDecimal denominator = sqrt((new BigDecimal(30)).multiply(sumOfXipow).subtract(sumOfXi.pow(2)), 15)
                        .multiply(sqrt((new BigDecimal(30).multiply(sumOfYipow).subtract(sumOfYi.pow(2))),15));
                resultMatrix[x][y] = numerator.divide(denominator, 5, RoundingMode.HALF_DOWN);
            }
        }
        return resultMatrix;
    }

    private static BigDecimal TWO = new BigDecimal(2L);
    public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, SCALE, ROUND_HALF_UP);

        }
        return x1;
    }

    public static void main(String[] args) {
        CorrCoef coef = new CorrCoef();
        coef.generateMatrix();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(coef.V[i][j] + " ");
            }
            System.out.println("; ");
        }
        System.out.println("\n\n\n\n");
        BigDecimal[][] resultMatrix = coef.corrCoef();
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
