package interview;

/**
 * 动态规划问题，大致可以通过以下四部进行解决。
 * 1.划分状态，即划分子问题
 * 2.状态表示，即如何让计算机理解子问题
 * 3.状态转移，即父问题是如何由子问题推导出来的
 * 4.确定边界，确定初始状态是什么？最小的子问题？最终状态又是什么。
 * 涉及的模型有线性模型（斐波那楔数）、区间模型以及树状模型
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 */
public class DynamicProgrammingDemo {

    public static void main(String[] args){
        int stageNum = 4;
        int ways = jumpFloor(stageNum);
        System.out.println(" 台阶有 " + stageNum + "级，共有" + ways + "跳法");
    }

    /**
     * 计算跳的方法
     * @param target
     * @return
     */
    public static int jumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
