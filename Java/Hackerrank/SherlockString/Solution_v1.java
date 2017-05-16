package Hackerrank.SherlockString;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by tanmays on 14/5/17.
 * Problem definition to be found here: https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */
public class Solution_v1 {
    static String WatsonString0 = "aabbcdabdd";
    static String WatsonString5 = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
    public static void main(String args[]) {
        Scanner inputscanner = new Scanner(System.in);
        String WatsonString = inputscanner.nextLine();
        //String WatsonString = WatsonString0;
        System.out.println(SolveWatsonRiddle(WatsonString));
    }

    private static String SolveWatsonRiddle(String WatsonString) {

        String RiddleAnswer = "YES";
        int WatsonStringLength = WatsonString.length();
        Map<Character, Integer> WatsonStringDictionary = new HashMap<>();

        for (int i = 0; i < WatsonStringLength; i++){
            if(WatsonStringDictionary.get(WatsonString.charAt(i)) == null)
                WatsonStringDictionary.put(WatsonString.charAt(i), 1);
            else
                WatsonStringDictionary.put(WatsonString.charAt(i),
                        WatsonStringDictionary.get(WatsonString.charAt(i)) + 1);
        }

        for (char eachkey:WatsonStringDictionary.keySet())
            System.out.print("(" + eachkey + ", " + WatsonStringDictionary.get(eachkey) +"); ");

        // Checking if initial riddle is "valid"
        int tempfreq1 = -1, tempfreq2 = -1;
        RiddleAnswer = "YES";
        for (char eachkey:WatsonStringDictionary.keySet()) {
            if (tempfreq1 == -1) {
                tempfreq1 = WatsonStringDictionary.get(eachkey);
                continue;
            }
            if (tempfreq1 != WatsonStringDictionary.get(eachkey)) {
                RiddleAnswer = "NO";
                break;
            }
        }
        if(RiddleAnswer == "YES")
            return RiddleAnswer;

        // Checking for cases where initial string validity fails
        tempfreq1 = tempfreq2 = -1;
        int tempfreq1_counter = 0;
        int tempfreq2_counter = 0;
        for (char eachkey:WatsonStringDictionary.keySet()) {
            if (tempfreq1 == -1 || tempfreq1 == WatsonStringDictionary.get(eachkey)) {
                tempfreq1 = WatsonStringDictionary.get(eachkey);
                tempfreq1_counter++;
                continue;
            }
            if (tempfreq2 == -1 || tempfreq2 == WatsonStringDictionary.get(eachkey)) {
                tempfreq2 = WatsonStringDictionary.get(eachkey);
                tempfreq2_counter++;
                continue;
            }
            if (tempfreq1 != WatsonStringDictionary.get(eachkey) && tempfreq2 != WatsonStringDictionary.get(eachkey)) {
                RiddleAnswer = "NO";
                return RiddleAnswer;
            }
        }

        if (tempfreq1_counter == 1) {
            if (tempfreq1 == tempfreq2 + 1 || tempfreq1 == 1)
                RiddleAnswer = "YES";
        } else if (tempfreq2_counter == 1) {
            if (tempfreq2 == tempfreq1 + 1 || tempfreq2 == 1)
                RiddleAnswer = "YES";
        } else
            RiddleAnswer = "NO";


        return RiddleAnswer;
    }
}
