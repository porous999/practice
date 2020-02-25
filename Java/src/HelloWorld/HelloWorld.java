package HelloWorld;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HelloWorld {

    public static void main(String[] args) throws IOException, ParseException {
        // TODO Auto-generated method stub

        System.out.println("Hello world!!");
        System.out.println(String.format("Hello world!! %s",  Arrays.toString(new int[]{1, 2})));

        deleteDirectoryRecursively(new File("/home/tanmays/temp/00delete/23008"));
        new File("/home/tanmays/temp/00delete/23008");
        Date hereDate = new Date();
        Format dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tempDate = dateFormat.format(hereDate);

        String[] dateList = tempDate.split(" ");
        String thisDate = dateList[0];
        String statsS3KeyFormat = "aggregated-stats/top_10_switchport_tx_peakbps_by_site_id/dt=%s/last_30_day";
        String s3Key = String.format(statsS3KeyFormat, thisDate);
        System.out.println("Here: " + s3Key);

        //System.out.format("Hello world!! %d",new int[]{1, 2});

        //System.out.println("abcd".compareTo("abcde"));
    }

    private static void deleteDir(String dirPath) {
        File dirFile = new File(dirPath);
        File[] files = dirFile.listFiles();
        for (File thisFile:files) {
            thisFile.delete();
        }
        dirFile.delete();
    }


    static void deleteDirectoryRecursively(File file) throws IOException {
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

}
