package algorithm.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // 方法一：暴力破解，穷举两数组合
    public int[] twoSum3(int[] nums, int target) {
        int n = nums.length;
        // 双重 for 循环
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // 找不到，返回 -1
        return new int[]{-1};
    }

    // 方法二：使用 HashMap 保存所有数的信息
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;

        // 定义一个哈希表
        HashMap<Integer, Integer> map = new HashMap<>();

        // 1. 遍历数组，将数据全部保存入 hash 表
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        // 2. 再次遍历数组，寻找每个数对应的那个数是否存在
        for (int i = 0; i < n; i++) {
            int num = target - nums[i];
            // 如果那个数存在，并且不是当前数本身，就直接返回结果
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[]{i, map.get(num)};
            }
        }

        return new int[]{-1};

    }

    // 方法三：改进 HashMap
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1};
    }


    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};
        int target1 = 9;
        int target2 = 6;
        int target3 = 6;

        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums3, target3);
        System.out.println(Arrays.toString(result));


    }
}


