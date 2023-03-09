package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution017 {
    private Map<Character,Integer> sCount = new HashMap<Character, Integer>();
    private Map<Character,Integer> tCount = new HashMap<Character,Integer>();

    public String minWindow(String s, String t) {
        if (t.length() > s.length()){
            return "";
        }
//        初始化t的字母数据
        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i),0) + 1);
        }

        int n = s.length();
        int left = 0;
        int right = -1;
        int ansL = -1;
        int ansR = -1;
        int len = n + 1;

        while (right < n){
            right++;

            if (right < n) {
                char rch = s.charAt(right);
                if (tCount.containsKey(rch)) {
                    sCount.put(rch, sCount.getOrDefault(rch, 0) + 1);
                }
            }

            while (left <= right && check()){
                if (len > right - left + 1){
                    len = right - left + 1;
                    ansL = left;
                    ansR = right + 1;
                }

                char lch = s.charAt(left);
                if (tCount.containsKey(lch)){
                    sCount.put(lch,sCount.get(lch) - 1);
                }
                left ++;
            }
        }

        return ansL == -1 ? "" : s.substring(ansL,ansR);
    }

    private boolean check() {
        for (Map.Entry<Character,Integer> entry : tCount.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();

            if (sCount.getOrDefault(key,0) < val){
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
