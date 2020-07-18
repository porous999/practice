package helloworld;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Miscellaneous {
    static final Logger miscLogger = Logger.getLogger(Miscellaneous.class);
    private Miscellaneous() { }

    private static final Random rand = new Random();

    static void testGetRandomNumArray() {
        int n = 20;
        int[] array = getRandomNumArray(n);
        for (int i = 0; i < n; i++) {
            miscLogger.info(array[i] + " ");
        }
    }

    static List<Integer> getListOfNumbers(int listSize) {
        List<Integer> myList = new ArrayList<>();
        int num;
        for (int i = 0; i < listSize; i++) {
            num = rand.nextInt(listSize);
            num = num * (-1 * (num % 2));   // throw -ve and +ve numbers in the mix
            myList.add(num);
        }
        return myList;
    }

    static int[] getRandomNumArray(int n) {
        int[] numinserted = new int[n];
        int[] arrayGen = new int[n];
        int randInt = 0;
        for (int i = 0; i < n; i++) {
            while (numinserted[randInt] == 1)
                randInt = rand.nextInt(n);
            arrayGen[i] = randInt;
            numinserted[randInt] = 1;
        }
        return arrayGen;
    }

    static void printListOfNumbers(List<Integer> listOfNumbers) {
        StringBuilder numberListStringBuilder = new StringBuilder();
        for (int eachNum:listOfNumbers) {
            numberListStringBuilder.append(String.format("%d, ", eachNum));
        }
        numberListStringBuilder.deleteCharAt(numberListStringBuilder.length() - 1);
        numberListStringBuilder.deleteCharAt(numberListStringBuilder.length() - 1);
        miscLogger.info(numberListStringBuilder.toString());
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
        miscLogger.info(allValStr);
        return smallest;
    }
}
