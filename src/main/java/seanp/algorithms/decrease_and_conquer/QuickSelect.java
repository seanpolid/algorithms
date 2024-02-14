package seanp.algorithms.decrease_and_conquer;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {

	private static Random random = new Random(); 

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(0, nums.length - 1, nums, k);
    }

    private static int quickSelect(int low, int high, int[] nums, int k) {
        int s = partitionRandomized(low, high, nums, k);

        int pos = high - s + 1;
        if (pos == k) 
            return nums[s];
        else if (pos < k) 
            return quickSelect(low, s - 1, nums, k - pos);
        else 
            return quickSelect(s + 1, high, nums, k);
    }
    
    private static int partitionMOM(int low, int high, int[] nums, int k) {
    	int pivot = findMedianOfMedians(low, high, nums);
    	int pivotIndex = findIndex(low, nums, pivot);
    	
        swap(nums, low, pivotIndex);
        pivotIndex = low;
        
        int s = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] < nums[pivotIndex]) {
                swap(nums, ++s, i);
            }
        }

        swap(nums, low, s);
        
        return s;
    }
    
    private static int findMedianOfMedians(int low, int high, int[] nums) {
    	int numMedians = (high - low) / 5 + 1;
    	int[] medians = new int[numMedians];
    	
    	for (int i = 0; i < numMedians; i++) {
    		int start = low + (5 * i);
    		int end = start + Math.min(5, high - start + 1);
            
    		int[] array = Arrays.copyOfRange(nums, start, end);
    		Arrays.sort(array);
    		
    		int mid = array.length / 2;
    		medians[i] = array[mid];
    	}
    	
    	if (medians.length == 1) {
    		return medians[0];
    	} else {
    		return findMedianOfMedians(0, medians.length - 1, medians);
    	}
    }

    private static int findIndex(int low, int[] nums, int target) {
        int index = low;
        for (int i = low; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            }
        }

        return index;
    }

    private static int partitionRandomized(int low, int high, int[] nums, int k) {
        int pivotIndex = low == high ? low : low + random.nextInt(high - low);
        swap(nums, low, pivotIndex);
        pivotIndex = low;
        
        int s = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] < nums[pivotIndex]) {
                swap(nums, ++s, i);
            }
        }

        swap(nums, low, s);
        
        return s;
    }
    
    private static int partitionBasic(int low, int high, int[] nums, int k) {
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

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
