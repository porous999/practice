package helloworld;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MiscellaneousTest {
    Class<Miscellaneous> miscellaneousClass = Miscellaneous.class;

    @Test
    public void testGetRandomNumArray() {
    }

    @Test
    public void getRandomNumArray() {
    }

    @Test
    public void maxOfValues() {
    }

    @Test
    public void minOfValues() {
    }

    @Test
    public void testas() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method testFileExistsMethod = miscellaneousClass.getDeclaredMethod("testFileExists", String.class);
        testFileExistsMethod.setAccessible(true);
        assertFalse((boolean) testFileExistsMethod.invoke(miscellaneousClass,"asdfafaf"));
    }
}