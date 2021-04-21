package helloworld;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.Math.abs;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        System.out.println("Hello world!!");
        System.out.println(String.format("Hello world!! %s",  Arrays.toString(new int[]{1, 2})));

        //try1();
        //fetchingExercise();

        // compareTimestampStr();

        //useInstant();

        //System.out.format("Hello world!! %d",new int[]{1, 2});

        //System.out.println("abcd".compareTo("abcde"));
    }

    static String fetchWordInBetweenFromText(String textStr, String prevWord, String nextWord) {

        String wordOfInterest = "";

        String[] messageSplit = textStr.split("\\s+");
        int indexForPrevWord = indexOfWordInArray(prevWord, messageSplit);

        if (indexForPrevWord > -1) {
            while (indexForPrevWord++ < messageSplit.length && !messageSplit[indexForPrevWord].equals(nextWord)) {
                wordOfInterest = wordOfInterest.concat(messageSplit[indexForPrevWord]);
                if (!wordOfInterest.isEmpty()) {
                    wordOfInterest = wordOfInterest.replaceAll("\"", "");
                }
            }
        }

        return wordOfInterest;
    }

    /**
     * Returns index of the word, if detected, else returns -1
     * @param word          Word of interest
     * @param textArray     Array to search for the word
     * @return              Index of the word in the textArray, if detected. Else -1
     */
    public static int indexOfWordInArray(String word, String[] textArray) {
        int indexOfInterest = -1;
        for (int i = 0; i < textArray.length; i++) {
            String eachword = textArray[i];
            if (eachword.equals(word)) {
                indexOfInterest = i;
                break;
            }
        }
        return indexOfInterest;
    }

    private static void deleteDirectoryRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectoryRecursively(entry);
                    entry.delete();
                }
            }
        }
    }

    /*
     * Write a function: solution(A)

     that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

     For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

     Given A = [1, 2, 3], the function should return 4.

     Given A = [−1, −3], the function should return 1.

     Assume that:

     N is an integer within the range [1..100,000];
     each element of array A is an integer within the range [−1,000,000..1,000,000].
     Complexity:

     expected worst-case time complexity is O[N];
     expected worst-case space complexity is O[N] (not counting the storage required for input arguments).


     */

    static int solution(int[] A) {
        return findMinMissingNumber(A);
    }

    static int getSum(String ... nums) {
        int sum = 0;
        for (String eachNum : nums)
            sum += Integer.parseInt(eachNum);

        return sum;
    }

    static int findMinMissingNumber(int[] thisArray) {

        int maxValPossibleInA = 1_000_000;
        int[] parallelArray = new int[maxValPossibleInA + 1];

        for (int a: thisArray) {
            if (a > 0)
                parallelArray[a] = 1;
        }
        for (int i = 1; i < maxValPossibleInA; i++) {
            if (parallelArray[i] == 0) {
                return i;
            }
        }
        return 1;
    }

}
