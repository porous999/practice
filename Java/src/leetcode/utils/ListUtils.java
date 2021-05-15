package leetcode.utils;

import java.util.Iterator;
import java.util.List;

public class ListUtils<T> {

    public boolean isSameList(List<T> listOne, List<T> listTwo) {
        if (listOne.size() != listTwo.size())
            return false;
        boolean sameList = true;
        Iterator<T> theListOneIt = listOne.iterator();
        Iterator<T> theListTwoIt = listTwo.iterator();
        while (theListOneIt.hasNext()) {
            T list1Element = theListOneIt.next();
            T list2Element = theListTwoIt.next();
            if (!list1Element.equals(list2Element)) {
                sameList = false;
                break;
            }
        }
        return sameList;
    }
}
