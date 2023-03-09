package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution76 {

    private Map<Character,Integer> orit = new HashMap<Character,Integer>();
    private Map<Character,Integer> cnts = new HashMap<Character,Integer>();

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            orit.put(ch, orit.getOrDefault(ch,0) + 1);
        }
        int ansL = -1, ansR = s.length();
        int len = s.length() + 1;
        int right = -1;
        int left = 0;
        int sLen = s.length();

        while (right < sLen){
            right++;

            if (right < sLen){
                char rch = s.charAt(right);
                if (orit.containsKey(rch)){
                    cnts.put(rch, cnts.getOrDefault(rch,0) + 1);
                }
            }

            while (check() && left <= right){
                if (right - left + 1 < len){
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                char lch = s.charAt(left);
                if (orit.containsKey(lch)){
                    cnts.put(lch, cnts.getOrDefault(lch,0) - 1);
                }
                left ++;
            }

        }

        return ansL == -1 ? "" : s.substring(ansL,ansR);

    }

    private boolean check() {

        for (Map.Entry<Character, Integer> characterIntegerEntry : orit.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            Integer val = characterIntegerEntry.getValue();
            if (cnts.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
