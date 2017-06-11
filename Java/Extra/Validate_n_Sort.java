package Extra;

import java.security.Key;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Testcases
6
abcde
agtyz
mnoptr
abc
qyu
ab
*/

/**
 * Created by tanmays on 9/6/17.
 */
public class Validate_n_Sort {
    public static void main (String[] args) {
        Scanner myscanner = new Scanner(System.in);
        int numofcases = myscanner.nextInt();
        String tempstring = null;
        //myscanner.next();
        boolean valid = true;

        //String[] testcases = new String[numofcases];
        List<String> testcases = new LinkedList<>();

        for (int i = 0; i < numofcases; i++) {
            tempstring = myscanner.next();
            valid = true;
            for (int j = 0; j < tempstring.length() - 1; j++) {
                if (tempstring.charAt(j) > tempstring.charAt(j+1)) {
                    System.out.println("Cancelling string: " + tempstring);
                    valid = false;
                    break;
                }
            }

            if(valid)
                testcases.add(tempstring);

        }

        //testcases = sortlist (testcases);
        Collections.sort(testcases);

        System.out.println("Strings accepted are:");
        for (int i = 0; i < testcases.size(); i++)
            System.out.println(testcases.get(i));

    }

    /*
    private static List<String> sortlist(List<String> testcases) {

        String temp;

        for (int i = 0; i < testcases.size() - 1; i++){
            for (int j = i + 1; j < testcases.size(); j++)
            if (testcases.get(i).compareTo(testcases.get(j)) > 0) {
                temp = testcases.get(i);
                testcases.set(i, testcases.get(j));
                testcases.set(j, temp);
            }
        }
        return testcases;
    }
    */
}
