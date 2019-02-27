package leetcode;

import java.util.*;

/**
 * @Auther: user
 * @Date: 2019/2/26 23:36
 * @Description:Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * 难点还在于怎么判断凑出来的几个数是唯一的
 */
public class ThreeSum {
    /**
     * @Description: 这个没有过，但是我不知道是什么问题
     * @param
     * @return
     * @throws
     * @author user
     * @date 2019/2/27 23:10
     */
    public List<List<Integer>> threeSum_1(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int index1 = 0; index1 < nums.length - 2 ; index1 ++) {
            for (int index2 = index1 + 1; index2 < nums.length -1; index2 ++) {
                for (int index3 = index2 + 1; index3 < nums.length; index3++) {
                    if (nums[index1] + nums[index2] + nums[index3] == 0) {
                        List<Integer> listTemp = new ArrayList<>();
                        listTemp.add(nums[index1]);
                        listTemp.add(nums[index2]);
                        listTemp.add(nums[index3]);
                        if (!listSameDecide(listTemp,result))
                            result.add(listTemp);
                    }
                }
            }
        }
        return result;
    }
    

    /**
     * @Description: 判断这个list是否已经在结果中了
     * @param
     * @return
     * @throws
     * @author user
     * @date 2019/2/27 23:00
     */
    public boolean listSameDecide(List<Integer> inputList, List<List<Integer>> targetList) {
        Collections.sort(inputList);
        for (List<Integer> list : targetList) {
            Collections.sort(list);
            boolean same = true;

            for (int index = 0; index < list.size(); index++) {
                if (list.get(index).equals(inputList.get(index))) continue;
                else {
                    same = false;
                    break;
                }
            }
            if (same) {return true;}
        }
        return false;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int index = 0; index < nums.length - 2; index++) {
            int start = index + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] + nums[index] > 0) {
                    end--;
                } else if (nums[start] + nums[end] + nums[index] < 0) {
                    start++;
                } else {
                    List<Integer> listTemp = new ArrayList<>();
                    listTemp.add(nums[start]);
                    listTemp.add(nums[end]);
                    listTemp.add(nums[index]);
                    if (! listSameDecide(listTemp,result))
                        result.add(listTemp);
                    start++;
                }
            }
        }
        return result;
    }
}
