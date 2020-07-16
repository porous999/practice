package helloworld;

import java.io.File;
import java.util.Random;

public class Miscellaneous {
    private Miscellaneous() {}

    static void testGetRandomNumArray() {
        int n = 20;
        int[] array = getRandomNumArray(n);
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static int[] getRandomNumArray(int n) {
        int[] numinserted = new int[n];
        int[] arrayGen = new int[n];
        Random rand = new Random();
        int rand_int = 0;
        for (int i = 0; i < n; i++) {
            while (numinserted[rand_int] == 1)
                rand_int = rand.nextInt(n);
            arrayGen[i] = rand_int;
            numinserted[rand_int] = 1;
        }
        return arrayGen;
    }

    private static boolean testFileExists(String fileName) {
        return new File(fileName).exists();
    }

    public static double maxOfValues(double ... a) {
        double largest = a[0];
        for (double eachVal : a) {
            if (eachVal > largest)
                largest = eachVal;
        }
        return largest;
    }

    public static double minOfValues(double ... a) {
        double smallest = a[0];
        for (double eachVal : a) {
            if (eachVal < smallest)
                smallest = eachVal;
        }

        StringBuilder allValStr = new StringBuilder();

        for (double eachMaxKbpsVal : a) {
            if (allValStr.length() == 0) {
                allValStr.append(eachMaxKbpsVal);
                continue;
            }
            allValStr.append(",");
            allValStr.append(eachMaxKbpsVal);
        }
        System.out.println(allValStr);
        //Collections.min();
        return smallest;
    }
}
