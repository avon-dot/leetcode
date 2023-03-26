package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 10000000;
        int n = nums.length;

        for (int first = 0; first < n; first++) {
            int left = first + 1;
            int right = n - 1;

            while (left < right){
                int sum = nums[first] + nums[left] + nums[right];
                if (sum == target){
                    return sum;
                }

                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }

                if (sum > target){
                    int k = right - 1;
                    while (left < k && nums[k] == nums[right]){
                        k --;
                    }
                    right = k;
                } else {
                    int j = left + 1;
                    while (j < right && nums[j] == nums[left]){
                        j ++;
                    }
                    left = j;
                }
            }
        }

        return best;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
