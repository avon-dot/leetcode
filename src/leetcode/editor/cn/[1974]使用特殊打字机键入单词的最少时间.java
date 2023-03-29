package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1974 {
    public int minTimeToType(String word) {
        if (word == null){
            return 0;
        }

        int n = word.length();
        int step = Math.min(word.charAt(0) - 'a',26 - word.charAt(0) + 'a');
        int ans = step + 1;
        for (int i = 1; i < n; i++) {
            char pre = word.charAt(i - 1);
            char curr = word.charAt(i);
            int sub = Math.abs(curr - pre);
            step = Math.min(sub,26 - sub);
            ans = ans + step + 1;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
