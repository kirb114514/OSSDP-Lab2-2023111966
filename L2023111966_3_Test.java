import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class L2023111966_3_Test {

    /**
     * 测试用例设计原则：等价类划分原则
     * 测试目标：验证最大整除子集算法在正常输入下的表现。
     */
    @Test
    public void testLargestDivisibleSubset() {
        Solution3 solution = new Solution3();

        // 输入：{1, 2, 3}
        int[] input1 = {1, 2, 3};
        List<Integer> expected1 = List.of(1, 2); // 最大整除子集是 [1, 2]
        assertEquals(expected1, solution.largestDivisibleSubset(input1));

        // 输入：{1, 2, 4, 8}
        int[] input2 = {1, 2, 4, 8};
        List<Integer> expected2 = List.of(1, 2, 4, 8); // 最大整除子集是 [1, 2, 4, 8]
        assertEquals(expected2, solution.largestDivisibleSubset(input2));

        // 输入：{1, 3, 9, 27}
        int[] input3 = {1, 3, 9, 27};
        List<Integer> expected3 = List.of(1, 3, 9, 27); // 最大整除子集是 [1, 3, 9, 27]
        assertEquals(expected3, solution.largestDivisibleSubset(input3));

        // 输入：{5, 10, 20, 30}
        int[] input4 = {5, 10, 20, 30};
        List<Integer> expected4 = List.of(5, 10, 20); // 最大整除子集是 [5, 10, 20]
        assertEquals(expected4, solution.largestDivisibleSubset(input4));
    }

    /**
     * 测试用例设计原则：边界值分析
     * 测试目标：验证算法对空数组和数组长度为1的情况的处理。
     */
    @Test
    public void testEdgeCases() {
        Solution3 solution = new Solution3();

        // 空数组
        int[] input1 = {};
        List<Integer> expected1 = List.of();
        assertEquals(expected1, solution.largestDivisibleSubset(input1));

        // 只有一个元素的数组
        int[] input2 = {10};
        List<Integer> expected2 = List.of(10); // 子集只能包含自己
        assertEquals(expected2, solution.largestDivisibleSubset(input2));
    }

    /**
     * 测试用例设计原则：错误推测
     * 测试目标：验证算法是否能处理重复的元素（题目中没有重复，所以这是个额外的边界测试）
     */
    @Test
    public void testWithDuplicates() {
        Solution3 solution = new Solution3();

        // 虽然题目中没有重复元素，但我们可以测试如果有重复元素时的反应
        int[] input = {1, 2, 2, 4, 8};
        List<Integer> expected = List.of(1, 2, 4, 8); // 重复元素 2 被忽略
        assertEquals(expected, solution.largestDivisibleSubset(input));
    }
}
