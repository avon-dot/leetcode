package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int first = 0; first < n; first++) {
            if (first != 0 && nums[first] == nums[first - 1]){
                continue;
            }

//            求两数之和
            int target = -nums[first];
            int third = n - 1;

            for (int second = first + 1; second < n; second++) {
//                重复的过滤
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target){
                    third --;
                }

                if (second == third){
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    List<Integer> tmp = new ArrayList<Integer>(3);
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    ans.add(tmp);
                }

            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
