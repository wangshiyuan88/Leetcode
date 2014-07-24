package b;

public class BestTimeToBuySellStock {
	
	public int maxProfit1(int[] prices) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(prices.length<=1)return 0;
	        int min = Integer.MAX_VALUE;
	        int max_profit = Integer.MIN_VALUE;
	        
	        for(int price : prices){
	            if(price < min){
	                min = price; 
	            }
	            max_profit = (max_profit > (price - min))? max_profit : price-min;
	        }
	        return max_profit;
	    }
	
	public int maxProfit2(int[] prices) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int profit = 0;
	        if(prices.length < 2)
	        return profit;
	        int buy = prices[0];
	        for(int i = 0 ; i < prices.length ; i++){
	          if(prices[i] > buy){
	              profit += prices[i] - buy;
	          }
	          buy = prices[i];
	        }
	        return profit;
	    }
	public int maxProfit3(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(prices.length<2)return 0;
       
        int[] before = new int[prices.length];
        int[] after = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int best = 0;
        for(int i = 0; i< prices.length ;i++){
            if(min > prices[i]){
                min = prices[i];
            }
            best = Math.max(prices[i] - min, best);
            before[i] = best;
        }
        best = 0;
        int max = Integer.MIN_VALUE;
        for(int i = prices.length-1; i>= 0; i--){
            if(max < prices[i]){
                max = prices[i];
            }
            best = Math.max(best,max - prices[i]);
            after[i] = best;
        }
        int maxProfit = 0;
        for(int i = 0; i < prices.length ; i ++){
            maxProfit = Math.max(before[i] + after[i], maxProfit);
        }
        return maxProfit;
    }
}
