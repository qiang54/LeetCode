/**
 * leetcode 123
 * 两次股票交易的核心是可以定义一个交易点，在这个交易点之前可以做一次交易(赚的最大数目的钱为firstProf)，
 * 在这个交易点之后可以做一个交易(赚的最大数目的钱是secondProf)
 */

public class maxProfit2 {

    public int maxProfit2(int[] prices){

        if(prices == null || prices.length < 1){
            return 0;
        }

        int len = prices.length;
        int[] ascandMax = new int[len];
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < len; i ++){
            //从前往后遍历，保存最小price
            //prices[i] - minPrices为遍历到节点i时的maxProfits
            maxProfit = Math.max(maxProfit, prices[i] - minPrice );
            minPrice = Math.min(minPrice, prices[i]);
            ascandMax[i] = maxProfit;
        }

        int[] descandMax = new int[len];
        int maxPrice = prices[len - 1];
        maxProfit = 0;
        for (int i = len - 2; i >= 0; i --){
            //从后往前遍历，保存最大price
            //maxPrice - prices[i]为遍历到节点i时的maxProfits
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
            descandMax[i] = maxProfit;

        }

        maxProfit = 0;
        for (int i = 0; i < len ; i ++){
            maxProfit = Math.max(maxProfit, ascandMax[i] + descandMax[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        maxProfit2 maxProfit = new maxProfit2();
        int profit = maxProfit.maxProfit2(prices);
        System.out.println(profit);
    }

}
