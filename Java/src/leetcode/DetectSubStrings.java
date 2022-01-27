package leetcode;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSubStrings {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return new ArrayList<>();
        return findAnagramsHereWithMaps(s, p);
    }

    private List<Integer> findAnagramsHereWithMaps(String mainStr, String searchStr) {
        List<Integer> detectedSubStrIndexList = new ArrayList<>();

        Map<Character, Integer> searchCharFreq = new HashMap<>();
        for (Character eachSearchChar : searchStr.toCharArray()) {
            searchCharFreq.put(eachSearchChar, searchCharFreq.getOrDefault(eachSearchChar, 0) + 1);
        }
        char[] mainCharArray = mainStr.toCharArray();
        Map<Character, Integer> mainStrCharFreq = new HashMap<>();
        for (int i = 0; i < searchStr.length(); i++) {
            mainStrCharFreq.put(mainCharArray[i], mainStrCharFreq.getOrDefault(mainCharArray[i], 0) + 1);
        }
        int mainIndex = 0;
        boolean addIndex = true;
        for (Map.Entry<Character, Integer> eachEntry : searchCharFreq.entrySet()) {
            if (!mainStrCharFreq.containsKey(eachEntry.getKey())
                    || mainStrCharFreq.get(eachEntry.getKey()).intValue() != searchCharFreq.get(eachEntry.getKey()).intValue()) {
                addIndex = false;
                break;
            }
        }
        if (addIndex)
            detectedSubStrIndexList.add(mainIndex);

        for (mainIndex = 1; mainIndex <= mainStr.length() - searchStr.length(); mainIndex++) {
            char outgoingChar = mainCharArray[mainIndex - 1];
            char incomingChar = mainCharArray[mainIndex + searchStr.length() - 1];
            if (mainStrCharFreq.getOrDefault(outgoingChar, 0) <= 1)
                mainStrCharFreq.remove(outgoingChar);
            else
                mainStrCharFreq.put(outgoingChar, mainStrCharFreq.getOrDefault(outgoingChar, 0) - 1);
            mainStrCharFreq.put(incomingChar, mainStrCharFreq.getOrDefault(incomingChar, 0) + 1);
            addIndex = true;
            for (Map.Entry<Character, Integer> eachEntry : searchCharFreq.entrySet()) {
                if (!mainStrCharFreq.containsKey(eachEntry.getKey())
                        || !mainStrCharFreq.get(eachEntry.getKey()).equals(searchCharFreq.get(eachEntry.getKey()))) {
                    addIndex = false;
                    break;
                }
            }
            if (addIndex)
                detectedSubStrIndexList.add(mainIndex);
        }

        return detectedSubStrIndexList;
    }

    private boolean isAnagramEfficient(String tempSubString, String searchedString) {
        if (tempSubString.length() != searchedString.length())
            return false;
        int[] residualCharFreq = new int[26];
        char[] additiveCharFreq = tempSubString.toCharArray();
        char[] subtractiveCharFreq = searchedString.toCharArray();
        for (int i = 0; i < tempSubString.length(); i++) {
            int addingIndex = additiveCharFreq[i] - 97;
            int subtractingIndex = subtractiveCharFreq[i] - 97;
            residualCharFreq[addingIndex]++;
            residualCharFreq[subtractingIndex]--;
        }
        for(int i = 0; i < 26; i++) {
            if (residualCharFreq[i] != 0)
                return false;
        }
        return true;
    }

    public List<Integer> findAnagramsHere(String mainString, String searchedString) {
        List<Integer> detectedSubStrIndexList = new ArrayList<>();
        int[] searchedCharFreq = new int[26];
        for (Character eachSearchedChar : searchedString.toCharArray()) {
            searchedCharFreq[eachSearchedChar - 97]++;
        }
        int[] mainStrCharFreq = new int[26];
        char[] mainCharArray = mainString.toCharArray();
        for (int i = 0; i < searchedString.length(); i++) {
            mainStrCharFreq[mainCharArray[i] - 97]++;
        }
        int mainIndex = 0;
        boolean addIndex = true;
        for (int i = 0; i < 26; i++) {
            if (mainStrCharFreq[i] != searchedCharFreq[i]) {
                addIndex = false;
                break;
            }
        }
        if (addIndex)   detectedSubStrIndexList.add(mainIndex);
        for (mainIndex = 1; mainIndex <= mainString.length() - searchedString.length(); mainIndex++) {
            char outgoingChar = mainCharArray[mainIndex - 1];
            char incomingChar = mainCharArray[mainIndex + searchedString.length() - 1];
            mainStrCharFreq[outgoingChar - 97]--;
            mainStrCharFreq[incomingChar - 97]++;
            addIndex = true;
            for (int i = 0; i < 26; i++) {
                if (mainStrCharFreq[i] != searchedCharFreq[i]) {
                    addIndex = false;
                    break;
                }
            }
            if (addIndex)   detectedSubStrIndexList.add(mainIndex);
        }
        return detectedSubStrIndexList;
    }
}
