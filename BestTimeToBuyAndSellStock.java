// You are given an array prices where prices[i] is the price of a given stock on the ith day. Return the maximum profit you can achieve from this transaction  


class BestTimeToBuyAndSellStock{

    public static int maxProfit(int[] prices){
        if (prices == null || prices.length <= 1) {
            return 0; // No opportunity to make a profit with less than two prices
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        for(int i=1; i<prices.length; i++){
           
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(stockPrices);

        System.out.println("Maximum profit: " + result);
    }

}