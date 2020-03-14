package oneDay;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {
    public static void main(String[] args) {
        int[] temp1 = new int[2];
        temp1 = twoNums1(new int[]{1, 5, 3, -1, 50}, 2);
        System.out.println(temp1[0] + " " + temp1[1]);

        int[] temp2 = new int[2];
        temp2 = twoNums2(new int[]{1, 5, 3, -1, 50}, 2);
        System.out.println(temp2[0] + " " + temp2[1]);
    }

    //方法一  暴力法 每个都值都遍历数组中所有值取得结果
    //方法二 二遍HashMap得到结果
    public static int[] twoNums1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{map.get(temp), i};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //方法三 一遍HashMap得到结果
    public static int[] twoNums2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}