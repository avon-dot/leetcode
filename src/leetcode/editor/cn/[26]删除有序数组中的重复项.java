package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution26 {
    public int removeDuplicates(int[] nums) {
        int ans = nums.length;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]){
                int index = i;
                while (index < ans){
                    nums[index - 1] = nums[index];
                    index ++;
                }
                ans --;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
