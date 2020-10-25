package extras;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by tanmays on 4/3/19.
 */
public class Traversal {

    public static void main(String[] args) {

        int n = 5;
        int[][] squareMatrix = getSquareMatrix(n);
        printMatrix(squareMatrix);
        traverseSquareMatrix(squareMatrix);
    }

    private static void traverseSquareMatrix(int[][] squareMatrix) {
        HashMap<Integer, List> costMap = new HashMap<>();
        int iStartIndex = 0, iEndIndex = squareMatrix.length;
        int jStartIndex = 0, jEndIndex = squareMatrix.length;

    }

    private static void printMatrix(int[][] squareMatrix) {
        int n = squareMatrix.length;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(squareMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] getSquareMatrix(int n) {
        int[][] squareMatrix = new int[n][n];
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                squareMatrix[i][j] = random.nextInt(50);
            }
        }
        return squareMatrix;
    }
}
