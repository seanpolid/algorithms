package seanp.algorithms.decrease_and_conquer;

import java.util.Random;

public class QuickSelect {

	private static Random random = new Random(); 

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(0, nums.length - 1, nums, k);
    }

    private int quickSelect(int low, int high, int[] nums, int k) {
        int s = partition(low, high, nums, k);

        int pos = high - s + 1;
        if (pos == k) 
            return nums[s];
        else if (pos < k) 
            return quickSelect(low, s - 1, nums, k - s);
        else 
            return quickSelect(s + 1, high, nums, k);
    }

    private int partition(int low, int high, int[] nums, int k) {
        int pivotIndex = low;

        int s = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] < nums[pivotIndex]) {
                swap(nums, ++s, i);
            }
        }

        swap(nums, low, s);
        
        return s;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
