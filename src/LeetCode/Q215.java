package LeetCode;

/**
 * Created by alvin on 2020/03/17.
 */
//quick selection
public class Q215 {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(a, k));
    }


    static public int findKthLargest(int[] nums, int k) {

        return kthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    static int kthLargest(int[] arr, int low,
                          int high, int k) {

        int partition = quickSelection(low, high, arr);

        // if partition value is equal to the kth position,
        // return value at k.
        if (partition == k)
            return arr[partition];

            // if partition value is less than kth position,
            // search right side of the array.
        else if (partition < k)
            return kthLargest(arr, partition + 1, high, k);

            // if partition value is more than kth position,
            // search left side of the array.
        else
            return kthLargest(arr, low, partition - 1, k);
    }

    static int quickSelection(int left, int right, int[] nums) {
        int pivot = left;
        int j = pivot;
        int i = left + 1;

        if (left < right) {
            for (int k = i; k <= right; k++) {
                if (nums[k] < nums[pivot]) {
                    j++;
                    int tmp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = tmp;
                }
            }
            int tmp = nums[left];
            nums[left] = nums[j];
            nums[j] = tmp;
            pivot = j;
        }
        return pivot;
    }
}



