package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = queries.length;
        List<Boolean> ans = new ArrayList<Boolean>(n);

        for (String query : queries) {
            if (query.length() < pattern.length()){
                ans.add(false);
                continue;
            }

            int qIndex = 0;
            int pIndex = 0;

            while (qIndex < query.length() && pIndex < pattern.length()){
                char p = pattern.charAt(pIndex);
                char q = query.charAt(qIndex);

                if (p == q){
                    pIndex ++;
                    qIndex ++;
                    continue;
                }

//                如果不相等的时候，q是小写字母，则往后面移动一位
                if (q >= 'a' && q <= 'z'){
                    qIndex ++;
                } else {
                  break;
                }
            }

//            如果说都没有遍历到最后一个元素
            if (pIndex < pattern.length()){
                ans.add(false);
            } else {
                while (qIndex < query.length()){
                    char q = query.charAt(qIndex);
                    if (q >= 'a' && q <= 'z'){
                        qIndex ++;
                    } else {
                        break;
                    }
                }

                if (qIndex == query.length()){
                    ans.add(true);
                } else {
                    ans.add(false);
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
