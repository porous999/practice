package extras;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindingSiblingsTest {
    FindingSiblings findingSiblingsObj = new FindingSiblings();

    @Test
    public void testGetSiblings() {
        assertEquals(new int[]{-1}, findingSiblingsObj.getSiblings(new int[]{1}, 1));
        assertEquals(new int[]{-1}, findingSiblingsObj.getSiblings(new int[]{1,2,3,4}, 4));
        assertEquals(new int[]{5}, findingSiblingsObj.getSiblings(new int[]{1,2,3,4,5}, 4));
        assertEquals(new int[]{4}, findingSiblingsObj.getSiblings(new int[]{1,2,3,4,5}, 5));
        assertEquals(new int[]{4, 6}, findingSiblingsObj.getSiblings(new int[]{1,2,3,4,5,6}, 5));
        assertEquals(new int[]{4, 5}, findingSiblingsObj.getSiblings(new int[]{1,2,3,4,5,6}, 6));
        assertEquals(new int[]{4, 5, 6}, findingSiblingsObj.getSiblings(new int[]{1,2,3,4,5,6,7}, 7));
        assertEquals(new int[]{-1}, findingSiblingsObj.getSiblings(new int[]{1,2,3,4,5,6,7}, 10));
    }

    void assertEquals(int[] expectedArray, int[] actualArray) {

        String expectedArrayStr = getArrayString(expectedArray);
        String actualArrayStr = getArrayString(actualArray);
        if (expectedArray.length == actualArray.length) {
            for (int i = 0; i < expectedArray.length; i++) {
                if (expectedArray[i] != actualArray[i]) {
                    break;
                }
            }
            return;
        }
        throw new AssertionError("Elementary difference:\nExpected: " + expectedArrayStr + "\nActual: " + actualArrayStr);
    }

    String getArrayString(int[] array) {
        StringBuilder arrayStr = new StringBuilder();
        arrayStr.append("{");
        for (int i = 0; i < array.length; i++) {
            arrayStr.append(array[i]);
            if (i < array.length - 1)
                arrayStr.append(", ");
        }
        arrayStr.append("}");
        return arrayStr.toString();
    }
}