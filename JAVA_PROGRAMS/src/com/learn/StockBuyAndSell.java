package com.learn;


//logic is sellingPrice - buyingPrice = profit has to be max 
//So find minimum buying price and highest selling price .This min buying price has to be present before the max selling price in the array
//so for each element subtract that element from the rest of the elements (elemnts after it) and see which result is high (high profit)
// this is o(n2)so
//for o(n), while trying to find the minimum, also try to find the max profit 

public class StockBuyAndSell {
	
	public static void main(String[] args) {
		
		int[] prices = {7, 10, 11, 3, 6, 9, 2};
		System.out.println("maxProfit will be "+ getMaxProfit(prices));
	}

	private static int getMaxProfit(int[] prices) {
		
		int res = 0;
		int minSoFar = prices[0];
		
		for(int i = 0; i < prices.length; i++) {
			
			minSoFar = Math.min(minSoFar, prices[i]);
			
			res = Math.max(res, prices[i]-minSoFar);
			
		}
		
		return res;
	}

}
