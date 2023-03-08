package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int windowSize = p.length();
        if (n < windowSize){
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<Integer>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount,pCount)){
            ans.add(0);
        }

        for (int left = 0; left < n - windowSize; left++) {
            sCount[s.charAt(left) - 'a']--;
            sCount[s.charAt(left + windowSize) - 'a']++;

            if (Arrays.equals(sCount,pCount)){
                ans.add(left + 1);
            }
        }

        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
