package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question121 {

		// 121. Best Time to Buy and Sell Stock

		// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int dayBought = 0;
        int result = 0;

        for (int i=1; i<prices.length; i++) {
            int dayBoughtPrice = prices[dayBought];
            int daySoldPrice = prices[i];

            if (daySoldPrice > dayBoughtPrice) {
                int tempMaxProfit = daySoldPrice - dayBoughtPrice;
                if (tempMaxProfit > result) {
                    result = tempMaxProfit;
                }
            }

            if (i == (prices.length - 1)) {
                dayBought += 1;
                i = dayBought;
            }
        }
        
        return result;
    }
}
