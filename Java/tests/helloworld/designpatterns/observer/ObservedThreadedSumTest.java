package helloworld.designpatterns.observer;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ObservedThreadedSumTest {

    private final Logger logger = Logger.getLogger(ObservedThreadedSumTest.class);
//    ObservedThreadedSum observedThreadedSumInst = new ObservedThreadedSum();

    @Test
    public void testThreading() throws InterruptedException {
        int[] numArray = {1,2,3,4,5,6,7,8,9,10};
        Map<String, Integer> totalsMap = new HashMap<>();
        totalsMap.put("tanny", 10_000);
        ObservedThreadedSum.SumMaster sumSubject = new ObservedThreadedSum().new SumMaster(totalsMap, numArray);
        sumSubject.processSum(sumSubject);
        logger.info(String.format("Result is here: sum: %s ; tanny: %d", totalsMap.getOrDefault("sum", 0),
                totalsMap.getOrDefault("tanny", 0)));
        assertEquals(55, (int) totalsMap.getOrDefault("sum", 0));
        assertEquals(10_000, (int) totalsMap.getOrDefault("tanny", 0));
    }
}