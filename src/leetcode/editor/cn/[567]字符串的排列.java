package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();
        if (s2.length() < windowSize){
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a'] ++;
            s2Count[s2.charAt(i) - 'a'] ++;
        }

        if (Arrays.equals(s1Count,s2Count)){
            return true;
        }

        for (int i = 0; i < s2.length() - windowSize; i++) {
            s2Count[s2.charAt(i) - 'a'] --;
            s2Count[s2.charAt(i + windowSize) - 'a'] ++;

            if (Arrays.equals(s1Count,s2Count)){
                return true;
            }
        }

        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
