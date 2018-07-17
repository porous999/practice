package HelloWorld;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static Extra.Utils.CalendarUtils.getCalenderYearWeekList;
import static Extra.Utils.CalendarUtils.getWeekFromCalendar;

public class HelloWorld {

    public static void main(String[] args) throws IOException, ParseException {
        // TODO Auto-generated method stub

        System.out.println("Hello world!!");
        //System.out.println("abcd".compareTo("abcde"));
        //System.out.println(getCalenderYearWeekList(dateTimestamp.Jan01_2011.timestamp, dateTimestamp.Jan24_2019.timestamp));
        /*Calendar c = Calendar.getInstance();
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        c.setTime( sdf.parse("31/12/2010"));
        System.out.println( getWeekFromCalendar(c) );*/
        getAllJsonTogether();
    }

    enum dateTimestamp {
        Jan01_2011(1293840000L),    // Saturday
        Jan01_2018(1514764800L),
        Dec28_2018(1545955200L),
        Dec31_2018(1546214400L),    // Monday
        Jan01_2019(1546300800L),
        Jan24_2019(1548288000L);

        private Long timestamp;

        dateTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }

    /*
     * Write a function:

     function solution(A);

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
    /*int getMinNumber(int[] thisArray) {

        int minNum = 1;
        for (int eachElement: thisArray) {
            if ()
        }
        return minNum;
    }*/

    @SuppressWarnings("I know them all")
    static void getAllJsonTogether() throws IOException {

        File inputMessageDir = new File("/home/tanmays/temp/15116/sparkout/allmessages");
        File outJsonFile = new File("/home/tanmays/temp/15116/allmessages.json");
        FileReader myFileReader;
        BufferedReader myBufferedReader;
        JSONObject myJsonObject;
        for (File eachFile : inputMessageDir.listFiles()) {
            myFileReader = new FileReader(eachFile);
            myBufferedReader = new BufferedReader(myFileReader);
            String eachline = myBufferedReader.readLine();
            while (null != eachline) {
                try {
                    myJsonObject = (JSONObject) new JSONParser().parse(eachline);
                    System.out.println();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }


}
