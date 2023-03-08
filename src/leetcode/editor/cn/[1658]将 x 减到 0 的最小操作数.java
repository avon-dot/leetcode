package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
//        右缀的所有值
        int sum = Arrays.stream(nums).sum();
        if (sum < x)return - 1;
        int right = 0;
//        刚开始左侧值为0
        int lsum = 0;
        int rsum = sum;
        int ans = n + 1;

//        开始滑动窗口
        for (int left = -1; left < n; ++left) {
            if (left != -1){
                lsum += nums[left];
            }

            while (right < n && lsum + rsum > x){
                rsum = rsum - nums[right];
                right ++;
            }

            if (lsum + rsum == x){
                ans = Math.min(ans,left + 1 + n - right);
            }

        }

        return ans > n ? -1 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
