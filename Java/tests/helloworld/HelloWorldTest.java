package helloworld;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static helloworld.HelloWorld.fetchWordInBetweenFromText;
import static helloworld.HelloWorld.solution;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by tanmays on 9/5/20.
 */
public class HelloWorldTest {
    Random random = new Random();

    @Test
    public void fetchingExercise() {
        String text = "Find the shark between to \"shark\" for here!";
        assertEquals("shark", fetchWordInBetweenFromText(text, "to", "for"));
    }

    @Test
    public void testStopWatch() throws InterruptedException {
        Stopwatch myStopwatch = Stopwatch.createStarted();
        Thread.sleep(1000);
        System.out.println("Start 1: " + myStopwatch.elapsed(TimeUnit.MILLISECONDS));
        myStopwatch.reset();
        Thread.sleep(1000);
        System.out.println("Reset 1: " + myStopwatch.elapsed(TimeUnit.MILLISECONDS));
        myStopwatch.start();
        Thread.sleep(1000);
        System.out.println("Start 2: " + myStopwatch.elapsed(TimeUnit.MILLISECONDS));
        Thread.sleep(1000);
        System.out.println("Start 2: " + myStopwatch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println(myStopwatch.stop());
    }

    @Test
    public void useInstant() {
        String when1 = "2020-05-05T06:10:02.795424597Z";
        String when2 = "2020-02-05T18:03:50.129Z";
        Instant whenInstant = Instant.parse(when1);
        Instant when2Instant = Instant.parse(when2);
        assertEquals(7733172666L, Duration.between(when2Instant, whenInstant).toMillis());
        assertEquals(-7733172667L, Duration.between(whenInstant, when2Instant).toMillis());
        assertFalse(Duration.between(whenInstant, when2Instant).getSeconds() > 30);
        assertFalse(whenInstant.isAfter(whenInstant));
        assertFalse(whenInstant.isBefore(whenInstant));
    }

    @Test
    public void byteTest() {
        String testString = "04f021972aba";
        byte[] testStringByteArray = testString.getBytes();
        for(byte eachByte : testStringByteArray) {
            System.out.print(eachByte + " ");
        }
        assertEquals(testString, new String(testStringByteArray));
    }

    @Test
    public void testSolution() {
        assertEquals(5, solution(new int[]{1, 3, 6, 4, 1, 2}));
        assertEquals(1, solution(new int[]{-1, -3, -6, -4}));
        assertEquals(1, solution(new int[]{1_000_000}));
        assertEquals(1, solution(new int[]{-1_000_000}));
    }

    @Test
    public void someRandomTests() {

        assertEquals(-1, "abcd".compareTo("abcde"));
        assertEquals(1, "abcde".compareTo("abcd"));
        assertEquals(0, "abcde".compareTo("abcde"));
    }
}