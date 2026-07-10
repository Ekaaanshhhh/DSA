class Solution {
    public int maxProfit(int[] prices) {
        int buy=0;
        int sell=1;
        int maxprofit=0;
        while(buy<prices.length && sell<prices.length)
        {
            int prof=prices[sell]-prices[buy];
            if(prof<0)
            {
                buy=sell;
                sell=sell+1;
            }
            else{
                sell++;
            }
            maxprofit=Math.max(prof,maxprofit);
        }
        return maxprofit;
    }
}