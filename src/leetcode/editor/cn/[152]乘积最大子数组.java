package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution152 {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, imax = 1, imin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            ans = Math.max(imax,ans);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
