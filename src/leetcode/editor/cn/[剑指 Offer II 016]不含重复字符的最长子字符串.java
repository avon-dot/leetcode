package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution016 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0 || n == 1){
            return n;
        }

        HashMap<Character,Integer> sSet = new HashMap<Character, Integer>();
        int maxLen = 0;
        int right = 0;

        for (int left = -1; left < n; left++) {
            if (left != -1){
                sSet.remove(s.charAt(left));
            }

            while (right < n && !sSet.containsKey(s.charAt(right))){
                sSet.put(s.charAt(right),0);
                right ++;
            }

            maxLen = Math.max(maxLen, right - left - 1);
        }

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
