package helloworld;

import com.google.common.base.Stopwatch;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import static helloworld.Miscellaneous.getListOfNumbers;
import static helloworld.Miscellaneous.printListOfNumbers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ForkJoinSpliteratorSumTest {
    static final Logger logger = Logger.getLogger(ForkJoinSpliteratorSumTest.class);

    @Test
    public void testBaseForkJoinPool() {
        logger.info("Checking null object!!");
        List<Integer> nullList = null;
        ForkJoinSpliteratorSum testNullForkJoinSplitSum = new ForkJoinSpliteratorSum(nullList);
        assertNull(testNullForkJoinSplitSum.invoke());

        logger.info("Checking empty object!!");
        List<Integer> emptyList = new ArrayList<>();
        ForkJoinSpliteratorSum testEmptyForkJoinSplitSum = new ForkJoinSpliteratorSum(emptyList);
        assertNotNull(testEmptyForkJoinSplitSum.invoke());
    }

    @Test
    public void testForkJoinPool() {
        List<Integer> listOfNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        printListOfNumbers(listOfNumbers);

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinSpliteratorSum testForkJoinSpliteratorSum = new ForkJoinSpliteratorSum(listOfNumbers);
        Stopwatch mySw = Stopwatch.createStarted();
        //Map<String, Object> sum = pool.invoke(new ForkJoinSpliteratorSum(listOfNumbers));
        Map<String, Object> sum = testForkJoinSpliteratorSum.invoke();
        logger.info(String.format("Time elapsed: %d", mySw.elapsed(TimeUnit.MICROSECONDS)));
        logger.info(String.format("Result is here: %s", sum.getOrDefault("sum", 0)));
        assertEquals(55, (int) sum.getOrDefault("sum", 0));
    }

    @Test
    public void testForkJoinPoolLargeSet() {
        int maxSize = 100_000;
        List<Integer> listOfNumbers = getListOfNumbers(maxSize);
        //printListOfNumbers(listOfNumbers);

        ForkJoinPool pool = new ForkJoinPool();
        //ForkJoinSpliteratorSum testForkJoinSpliteratorSum = new ForkJoinSpliteratorSum(listOfNumbers);
        Stopwatch mySw = Stopwatch.createStarted();
        Map<String, Object> sum = pool.invoke(new ForkJoinSpliteratorSum(listOfNumbers));
        logger.info(String.format("Time elapsed: %d", mySw.elapsed(TimeUnit.MICROSECONDS)));
        logger.info(String.format("Result is here: %s", sum.getOrDefault("sum", 0)));
        mySw.reset(); mySw.start();
        int linearSum = linearSumMethod(listOfNumbers);
        logger.info(String.format("Time elapsed in linear: %d", mySw.elapsed(TimeUnit.MICROSECONDS)));
        assertEquals(linearSum, (int) sum.getOrDefault("sum", 0));
    }

    private int linearSumMethod(List<Integer> listOfNumbers) {
        Map<String, Object> sumMap = new HashMap<>();
        for (int eachInt : listOfNumbers) {
            sumMap.put("sum", eachInt + (int) sumMap.getOrDefault("sum", 0));
        }
        return (int) sumMap.getOrDefault("sum", 0);
    }

}