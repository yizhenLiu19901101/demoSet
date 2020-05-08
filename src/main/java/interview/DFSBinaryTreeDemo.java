package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个含不同整数的集合，返回其所有的子集。
 * 一个集合的子集个数是“2 ^集合大小”，比如大小为n的集合的子集个数为2 ^ n，
 * 以集合的大小为2为例，它的可能性只有0,1,2,3四种方法，将其转化为二进制就是对应位上有没有数字：
 * 00、01、10、11四种，那么只要有数字就添加到集合里，最后就是所有的集合
 * @author milo
 */
public class DFSBinaryTreeDemo {
    // 成员变量，子集集合
    static List<List<Integer>> subsets = new ArrayList();
    // 主方法
    public static void main(String[] args) {
        int[] data = { 1, 2, 3 };
        // 求子集
        subsets(data);
        // 打印结果
        System.out.println("子集个数为" + subsets.size() + "个，分别为" + subsets);
    }

    /**
     * 得到集合
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        subsetsDFS(nums, 0, new ArrayList());
        return subsets;
    }

    /**
     * 深度优先搜索算法（Depth First Search），是图算法的一种
     * @param nums
     * @param level
     * @param subset
     */
    private static void subsetsDFS(int[] nums, int level, List<Integer> subset) {
        // 结束条件
        if (level == nums.length) {
            subsets.add(new ArrayList(subset));
            return;
        }
        // 选择当前元素
        subset.add(nums[level]);
        subsetsDFS(nums, level + 1, subset);
        // 不选择当前元素
        subset.remove(subset.size() - 1);
        subsetsDFS(nums, level + 1, subset);
    }
}
