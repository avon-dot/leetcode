package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0 || n == 1){
            return n;
        }

//        从左边滑动窗口到右边
        int right = 0;
        Set<Character> sset = new HashSet<Character>();
        int ans = 0;

        for (int left = -1; left < n; left++) {
            if (left != -1){
                sset.remove(s.charAt(left));
            }

            while (right < n && !sset.contains(s.charAt(right))){
                sset.add(s.charAt(right));
                right++;
            }

            ans = Math.max(ans,right-left-1);
        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
