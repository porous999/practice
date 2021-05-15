package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSubStrings {

    public List<Integer> findAnagrams(String mainString, String searchedString) {
        List<Integer> detectedSubStrIndexList = new ArrayList<>();
        for (int mainIndex = 0; mainIndex <= (mainString.length() - searchedString.length()); mainIndex++) {
            String tempSubString = mainString.substring(mainIndex, mainIndex + searchedString.length());
            if(isAnagram(tempSubString, searchedString))
                detectedSubStrIndexList.add(mainIndex);
        }
        return detectedSubStrIndexList;
    }

    private boolean isAnagram(String tempSubString, String searchedString) {
        if (tempSubString.length() != searchedString.length())
            return false;
        Map<Character, Integer> searchedCharFreq = new HashMap<>();
        for(char eachSearchedChar : searchedString.toCharArray()) {
            searchedCharFreq.put(eachSearchedChar, searchedCharFreq.getOrDefault(eachSearchedChar, 0) + 1);
        }
        Map<Character, Integer> tempSubStrFreq = new HashMap<>();
        for(char eachTempChar : tempSubString.toCharArray()) {
            tempSubStrFreq.put(eachTempChar, tempSubStrFreq.getOrDefault(eachTempChar, 0) + 1);
        }

        for (Map.Entry<Character, Integer> eachSearchedEntry : searchedCharFreq.entrySet()) {
            if (!eachSearchedEntry.getValue().equals(tempSubStrFreq.getOrDefault(eachSearchedEntry.getKey(), 0)))
                return false;
        }
        return true;
    }
}
