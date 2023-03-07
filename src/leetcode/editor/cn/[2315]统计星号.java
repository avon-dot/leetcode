package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2351 {
    public int countAsterisks(String s) {
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (flag && s.charAt(i) == '*'){
                sum ++;
                continue;
            }
            if (s.charAt(i) == '|'){
                flag = !flag;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
