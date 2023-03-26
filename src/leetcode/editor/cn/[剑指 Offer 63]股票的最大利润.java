package leetcode.editor.cn;

import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2){
            return 0;
        }

        int ans = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans,prices[i] - min);
            min = Math.min(min,prices[i]);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
