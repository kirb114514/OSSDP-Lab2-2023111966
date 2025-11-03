import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len == 0) return new ArrayList<>();

        // 去除重复元素并排序
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }
        nums = uniqueNums.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);

        // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];  // 用来记录链中的前一个元素
        Arrays.fill(dp, 1);  // 每个元素至少能包含自己
        Arrays.fill(prev, -1);  // 初始时没有前驱元素
        int maxSize = 1;  // 最大子集的大小
        int maxValIndex = 0;  // 最大子集的末尾元素的索引

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果 nums[i] 能被 nums[j] 整除且能形成更大的子集
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;  // 更新子集大小
                    prev[i] = j;  // 记录链中的前一个元素
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValIndex = i;  // 更新最大子集末尾的元素索引
            }
        }

        // 第 2 步：倒推获得最大子集
        List<Integer> res = new ArrayList<>();
        while (maxValIndex != -1) {
            res.add(nums[maxValIndex]);
            maxValIndex = prev[maxValIndex];  // 通过 prev 数组倒推
        }

        // 因为是倒推的结果，需要反转
        Collections.reverse(res);
        return res;
    }
}
