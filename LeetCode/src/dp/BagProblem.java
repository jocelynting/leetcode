package dp;

public class BagProblem {

    // 01 背包
    public static void testWeightBagProblem1DP(int[] weight, int[] value, int bagWeight){
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j > weight[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagWeight 背包的容量
     */
    public static void testWeightBagProblem2DP(int[] weight, int[] value, int bagWeight){

        // 创建dp数组
        int goods = weight.length;  // 获取物品的数量
        int[][] dp = new int[goods][bagWeight + 1];

        // 初始化dp数组，创建数组后，其中默认的值就是0
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }

        // 填充dp数组
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if (j < weight[i]) {
                    //当前背包的容量都没有当前物品i大的时候，是不放物品i的;那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                    dp[i][j] = dp[i-1][j];
                } else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     * dp[i-1][j-weight[i]]: 除了当前物品，剩下重量能放下物品的最大价值
                     */
                    int notput = dp[i-1][j];
                    int put = dp[i-1][j-weight[i]] + value[i];
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    // 完全背包
    //先遍历物品，再遍历背包
    private static void testCompletePack(int[] weight, int[] value, int bagWeight){
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++){ // 遍历物品
            for (int j = weight[i]; j <= bagWeight; j++){ // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }

    //先遍历背包，再遍历物品
    private static void testCompletePackAnotherWay(int[] weight, int[] value, int bagWeight){
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight; i++){ // 遍历背包容量
            for (int j = 0; j < weight.length; j++){ // 遍历物品
                if (i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }

    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagWeight = 4;
        testWeightBagProblem1DP(weight,value,bagWeight);
        System.out.println("\n----------");
        testWeightBagProblem2DP(weight,value,bagWeight);
        System.out.println("\n----------");
        testCompletePack(weight,value,bagWeight);
        System.out.println("\n----------");
        testCompletePackAnotherWay(weight,value,bagWeight);
        System.out.println("\n----------");
    }
}
