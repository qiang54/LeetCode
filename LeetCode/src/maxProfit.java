
/**
 * leetcode 121  买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 */

public class maxProfit {

    public int solution(int[] prices){

        if(prices == null || prices.length < 1){
            return 0;
        }

        int min = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++){
            if (min > prices[i]){
                //记录访问过的最小值
                min = prices[i];
            }else {
                //若当前访问的值不是最小值，则差值与
                if(max < prices[i] - min){
                    max = prices[i] - min;
                }
            }

            }

        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        maxProfit maxProfit = new maxProfit();
        int profit = maxProfit.solution(prices);
        System.out.println(profit);
    }
}
