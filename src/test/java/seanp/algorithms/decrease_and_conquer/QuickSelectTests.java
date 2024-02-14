package seanp.algorithms.decrease_and_conquer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class QuickSelectTests {

	@Test
	public void quickSelect_provided() {
		// Arrange
		int[] nums = {3, 2, 1, 5, 6, 4};
		int expected = 5;
		
		// Act
		int actual = QuickSelect.findKthLargest(nums, 2);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quickSelect_provided2() {
		// Arrange
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int expected = 4;
		
		// Act
		int actual = QuickSelect.findKthLargest(nums, 4);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quickSelect_decreasing() {
		// Arrange
		int[] nums = {6, 5, 4, 3, 2, 1};
		int expected = 3;
		
		// Act
		int actual = QuickSelect.findKthLargest(nums, 4);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quickSelect_manyRepeats() {
		// Arrange
		int[] nums = createManyRepeats(5000);
		int expected = -5;
		
		// Act
		int actual = QuickSelect.findKthLargest(nums, 5000);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	private int[] createManyRepeats(int n) {
		int[] nums = new int[n];
		for (int i = 0; i < 5; i++) {
			nums[i] = i;
		}
		for (int i = 5; i < n - 5; i++) {
			nums[i] = 1;
		}
		
		for (int i = n - 5; i < n; i++) {
			nums[i] = - (i - n + 6);
		}
		
		return nums;
	}
	
}
