package leetcode.editor;

public class SolutionSort {

    public int[] bubbleSort(int[] nums){
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j + 1] < nums[j]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) break;
        }
        return nums;
    }

    public int[] selectSort(int[] nums){
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i; j < n - 1; j++) {
                if (nums[j] < nums[index]){
                    index = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }

        return nums;
    }

    public int[] insertSort(int[] nums){
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            int index = i - 1;

            while (index >= 0 && curr < nums[index]){
                nums[index + 1] = nums[index];
                index --;
            }
            nums[index + 1] = curr;
        }

        return nums;
    }

    public int[] quickSort(int[] nums){
        int n = nums.length;
        return quickSort(nums,0,n - 1);
    }

    public int[] quickSort(int[] nums, int start, int end){
        if (start < 0 || end > nums.length || start > end){
            return nums;
        }

        int index = partition(nums,start,end);
        if (index > start){
            quickSort(nums,start,index - 1);
        }
        if (index < end){
            quickSort(nums,index + 1 ,end);
        }

        return nums;
    }

    private int partition(int[] nums, int start, int end) {
//        随机选择基准元素
        int pivot = (int)(start +Math.random() * (end - start + 1));
//        分区的下标
        int index = start - 1;
//        把基准元素放到队尾
        swap(nums, pivot, end);
        for (int i = start; i <= end ; i++) {
            if (nums[i] <= nums[end]){
                index ++;
                if (i > index){
                    swap(nums,i,index);
                }
            }
        }
        return index;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public int[] mergeSort(int[] nums){
        int n = nums.length;
        if (n < 2) return nums;

        return mergeSort(nums, 0, n-1);

    }

    private int[] mergeSort(int[] nums, int l, int r){
        if (l < r){
            int mid = (l + r)/ 2;

            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);

            merge(nums, l, mid, r);
        }

        return nums;
    }

    private void merge(int[] nums, int l, int mid, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - l + 1;
        int n2 = r - mid;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = nums[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = nums[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            }
            else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }
}


