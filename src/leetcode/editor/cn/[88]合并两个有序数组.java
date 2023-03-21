package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//       如果第二个数组是空的，直接返回第一个数组
        if (n == 0) return;
//       如果第一个数组为空或者最后一个元素已经是有序的，那么直接复制到2到1后即可
        if (m == 0 || nums1[m - 1] <= nums2[0]){
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
        }

        int left = m - 1;
        int right = n - 1;
        int index = m + n - 1;

        while (left >= 0 && right >= 0){
            if (nums1[left] <= nums2[right]){
                nums1[index] = nums2[right];
                right --;
            } else {
                nums1[index] = nums1[left];
                left --;
            }
            index --;
        }

//        当最小值在右边的时候
        if (right >= 0){
            for (int i = 0; i <= right; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
