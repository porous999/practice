package src.Hackerrank.AlgoritmicCrush;

import java.util.Scanner;

/**
 * Created by tanmays on 16/5/17.
 * Problem definition to be found here: https://www.hackerrank.com/challenges/crush
 */
public class Solution {
    public static void main (String args[]) {

        int N, M, a, b, k;
        int i, j;
        int largest = -1;

        Scanner thisScanner = new Scanner(System.in);
        N = thisScanner.nextInt();
        M = thisScanner.nextInt();

        int[] array_N = new int[N];
        int[][] array_M = new int[M][2];

        /*for (i = 0; i < N; i++)
            System.out.println(array_N[i]);*/

        for (i = 0; i < M; i++) {
            a = thisScanner.nextInt();
            b = thisScanner.nextInt();
            k = thisScanner.nextInt();

            for (j = a; j < b; j++) {
                array_N[j-1] = array_N[j-1] + k;
                if(largest < array_N[j-1])
                    largest = array_N[i];
            }
        }

        System.out.println(largest);
    }

}
