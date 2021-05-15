package leetcode;

import leetcode.utils.ListUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DetectSubStringsTest {
    Class<DetectSubStrings> detectSubStringsClass = DetectSubStrings.class;
    DetectSubStrings detectSubStrObj = new DetectSubStrings();
    ListUtils<Integer> thisListUtils = new ListUtils<>();

    @Test
    public void findAnagrams() {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(0);
        resultList.add(6);
        assertTrue(thisListUtils.isSameList(detectSubStrObj.findAnagrams("cbaebabacd", "abc"), resultList));
        resultList = new ArrayList<>();
        resultList.add(0);
        resultList.add(1);
        resultList.add(2);
        assertTrue(thisListUtils.isSameList(detectSubStrObj.findAnagrams("abab", "ab"), resultList));
        resultList = new ArrayList<>();
        resultList.add(1);
        assertTrue(thisListUtils.isSameList(detectSubStrObj.findAnagrams("baa", "aa"), resultList));
    }

    @Test
    public void testIsAnagram() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isAnagramMethod = detectSubStringsClass.getDeclaredMethod("isAnagram", String.class, String.class);
        isAnagramMethod.setAccessible(true);
        assertTrue((Boolean) isAnagramMethod.invoke(detectSubStrObj, "abc", "abc"));
        assertFalse((Boolean) isAnagramMethod.invoke(detectSubStrObj, "abc", "ab"));
        assertFalse((Boolean) isAnagramMethod.invoke(detectSubStrObj, "abc", "abs"));
        assertTrue((Boolean) isAnagramMethod.invoke(detectSubStrObj, "abc", "bac"));
    }
}