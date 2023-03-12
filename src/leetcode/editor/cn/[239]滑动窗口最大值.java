package leetcode.editor.cn;

import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1){
            return nums;
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);

        int n = nums.length;
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i],i});
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = priorityQueue.peek()[0];

        for (int left = 0; left < n - k; left++) {
            priorityQueue.offer(new int[]{nums[left + k],left + k});

            while (priorityQueue.peek()[1] <= left){
                priorityQueue.poll();
            }

            ans[left+1] = priorityQueue.peek()[0];
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
