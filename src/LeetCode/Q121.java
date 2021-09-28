package LeetCode;

import java.util.HashMap;
import java.util.Map;

/*
Best Time to Buy and Sell Stock
 */
public class Q121 {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {

        int tmpMax = prices[0];
        int tmpMin = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {

            if (tmpMax < prices[i])
                tmpMax = prices[i];
            if (tmpMin > prices[i] && i != prices.length - 1) {
                tmpMin = prices[i];
                tmpMax = prices[i];
            }
            result = Math.max(tmpMax - tmpMin, result);

        }
        return result;

    }

    public static int maxProfit2(int[] prices) {

        int tmpMax = 0;
        int tmpMin = Integer.MAX_VALUE;

        for (int price : prices) {

            if (price < tmpMin) { // min  값 찾기
                tmpMin = price;
            } else if (price - tmpMin > tmpMax) {
                tmpMax = price - tmpMin;
            }
        }
        return tmpMax;

    }
}
