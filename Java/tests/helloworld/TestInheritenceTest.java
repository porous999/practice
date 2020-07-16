package helloworld;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestInheritenceTest {

    @Test
    public void testInheritence() {
        TestInheritence.A aInstance = new TestInheritence().new A(100);
        assertEquals(100, aInstance.aInt);
        TestInheritence.B bInstance = new TestInheritence().new B(200);
        assertEquals(200, bInstance.aInt);
    }
}