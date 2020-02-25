package HelloWorld;

import org.apache.htrace.fasterxml.jackson.core.type.TypeReference;
import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello");
        //System.out.println(testFileExists());
        /*System.out.println(minOfValues(100,3.9,12.6,10.5,6.3,7.8));
        ArrayList temp = new ArrayList();
        temp.add(10.9);
        temp.add(2.4);
        temp.add(5.9);
        temp.add(9.1);

        Jedis thisJedis = new Jedis("redis-proxy-marvis-staging.mistsys.net");
        String apStatusStr = thisJedis.get("ApStatsStatus.5c-5b-35-0e-05-19");*/

        HashMap apStatusMap;

        /*if (null != apStatusStr) {
            apStatusMap = new ObjectMapper().readValue(apStatusStr, new TypeReference<HashMap<String,Object>>(){});
            if (apStatusMap.containsKey("last_seen_ms")
                    && (Long)apStatusMap.get("last_seen_ms") > (System.currentTimeMillis() - 80000)) {
                apStatusMap.put("connected", true);
                apStatusMap.put("uptime", (long)301);     // logic demands, uptime > 300
            }
        }*/


        /*System.out.println("===" + Collections.min(new ArrayList<Double>(){
            {
                add(100.0);
                add(3.9);
                add(12.6);
                add(10.5);
                add(6.3);
                add(7.8);
            }}));*/
    }

    static void testGetRandomNumArray() {
        int N= 20;
        int[] array = getRandomNumArray(N);
        for (int i = 0; i < N; i++) {
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

    private static boolean testFileExists() {
        boolean newFile = new File("asdfafaf").exists();
        return newFile;
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
