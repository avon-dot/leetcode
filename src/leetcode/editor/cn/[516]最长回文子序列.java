package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution516 {
    public int longestPalindromeSubseq(String s) {
//        字符串长度
        int n = s.length();
        if (n == 0 || n == 1){
            return n;
        }

        int maxLen = 1;

        // 第i个字符到第j个字符是回文
        boolean[][] dp = new boolean[n][n];
        for (int r = 1; r < n ; r++) {
            for (int l = 0; l < r ; l++) {
                if (s.charAt(r) == s.charAt(l) && (dp[l + 1][r - 1] || r - l <= 2)){
                    dp[l][r] = true;
                    maxLen = Math.max(r - l + 1,maxLen);
                }
            }
        }

        return maxLen;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
