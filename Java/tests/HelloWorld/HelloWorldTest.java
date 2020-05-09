package HelloWorld;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

import static HelloWorld.HelloWorld.fetchWordInBetweenFromText;
import static HelloWorld.HelloWorld.solution;
import static com.mist.ValidateDNSThrottle.convertRFC3339NanoToTimestamp;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by tanmays on 9/5/20.
 */
public class HelloWorldTest {

    @Test
    public void fetchingExercise() {
        String text = "Find the shark between to \"shark\" for here!";
        assertEquals("shark", fetchWordInBetweenFromText(text, "to", "for"));
    }

    @Test
    public void testConvertRFC3339NanoToTimestamp() {
        assertEquals("2020-05-05 11:40:02.795", convertRFC3339NanoToTimestamp("2020-05-05T06:10:02.795424597Z"));
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
        //System.out.println(whenInstant.compareTo(when2Instant));
        //System.out.println(whenInstant.compareTo(whenInstant));
        //System.out.println(when2Instant.compareTo(whenInstant));
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