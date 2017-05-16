package Hackerrank.PalindromeIndex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tanmays on 13/5/17.
 * Problem definition to be found here: https://www.hackerrank.com/challenges/palindrome-index
 */
public class Solution {

    private static List<String> caseList;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //long starttime = System.currentTimeMillis();

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int n = reader.nextInt();
        reader.nextLine(); //Consuming the \n

        String caseString;
        List<String> caseList = new ArrayList<>(n);

        for(int i = 0; i < n; i++)
            caseList.add(reader.nextLine());

        Iterator<String> myIterator = caseList.iterator();
        while (myIterator.hasNext()) {
            caseString = myIterator.next();
            //System.out.print (caseString + " -- ");
            System.out.println(palindromeIndex(caseString));
            //System.out.println(":" + numberOfCases[i]);
        }
        /*long endtime = System.currentTimeMillis();
		System.out.println((endtime - starttime)/1000);*/
    }

    private static int checkIfPalindrome(String caseString) {
        // TODO Auto-generated method stub

        int i;
        int caseStringLength = caseString.length();

        for (i = 0; i <= caseStringLength/2; i++){
            if (caseString.charAt(i) != caseString.charAt(caseStringLength - i - 1)) {
                //System.out.println(caseString + " is not palindrome!!");
                return i;
            }
        }
        //System.out.println(caseString + " is a palindrome");
        return -1;
    }

    public static int palindromeIndex(String caseString) {
        int index = -1;
        int i;

        int caseStringLength = caseString.length();
        String tempCaseString = null;

        index = checkIfPalindrome(caseString);

        if (index == -1)
            return index;
        else {
            StringBuilder tempCaseStringBuilder = new StringBuilder(caseString);
            tempCaseStringBuilder.deleteCharAt(index);
            tempCaseString = tempCaseStringBuilder.toString();
            if (checkIfPalindrome(tempCaseString) == -1)
                return index;
            else {
                tempCaseStringBuilder = new StringBuilder(caseString);
                tempCaseStringBuilder.deleteCharAt(caseStringLength - index - 1);
                tempCaseString = tempCaseStringBuilder.toString();
                if (checkIfPalindrome(tempCaseString) == -1)
                    return caseStringLength - index - 1;
            }
        }

        return index;
    }
}
