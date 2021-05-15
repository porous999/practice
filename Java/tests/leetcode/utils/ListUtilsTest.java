package leetcode.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListUtilsTest {

    @Test
    public void isSameList() {
        ListUtils<Integer> theListUtils =  new ListUtils<>();

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        List<Integer> secondList = new ArrayList<>();
        secondList.add(1);
        secondList.add(2);
        secondList.add(3);

        assertTrue(theListUtils.isSameList(firstList, secondList));
    }

    @Test
    public void isNotSameList() {
        ListUtils<Integer> theListUtils =  new ListUtils<>();

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        List<Integer> secondList = new ArrayList<>();
        secondList.add(1);
        secondList.add(2);
        secondList.add(5);

        assertFalse(theListUtils.isSameList(firstList, secondList));
    }
}