package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * @author vz
 *
 */
public class _1_Two_Sum {
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> allNums = new HashMap<Integer, Integer>();
	        for(int i = 0 ; i < nums.length; i++) {
	            allNums.put(nums[i], i);
	        }
	        for(int i = 0 ; i < nums.length; i++) {
	            int res = nums[i];
	            Integer diffRes = allNums.get(target - res);
	            if(diffRes != null && i != diffRes){
	                return new int[] {i, allNums.get(target - res)} ; 
	            }
	        }
	        return null;
	    }
	}
}
