
/**
 * leetcode 121
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
