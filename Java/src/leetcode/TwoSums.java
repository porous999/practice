package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanmays on 9/5/20.
 *
 * Prob statement: https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
class TwoSums {

    TwoSums() {}

    int[] twoSum(int[] nums, int target) {

        // return loopedMethod(nums, target);
        // return recursiveMethod(nums, target, 0, 1);
        return efficientMethod(nums, target);
    }

    // this method is inspired from their site
    private int[] efficientMethod(int[] nums, int target) {

        int[] result = new int[2];

        Map<Integer, Integer> intMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            intMap.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (intMap.containsKey(complement) && intMap.get(complement) != i) {
                result[0] = i;
                result[1] = intMap.get(complement);
                break;
            }
        }

        return result;
    }

    private int[] recursiveMethod(int[] nums, int target, int i, int j) {

        System.out.println(i + " " + j);

        if (nums[i] + nums[j] == target || ((i == nums.length - 2) && (j == nums.length - 1)))
            return new int[]{i, j};
        else if (j == nums.length - 1)
            return recursiveMethod(nums, target, i + 1, i + 2);
        else
            return recursiveMethod(nums, target, i, j + 1);
    }

    private int[] loopedMethod(int[] nums, int target) {
        int[] result = new int[2];
        boolean targetAcquired = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result[0] = i;
                result[1] = j;
                if (target == (nums[i] + nums[j])) {
                    targetAcquired = true;
                    break;
                }
            }
            if (targetAcquired)
                break;
        }

        return result;
    }
}
