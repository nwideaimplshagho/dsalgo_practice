package org.educative.array;

/**
 * Statement We're given a sorted array, nums, containing positive integers only. We have to
 * rearrange the array so that when returned, the index of the array will have the
 * largest number, the index will have the smallest number, the index will have
 * the second largest number, the index will have the second smallest number, and
 * so on. In the end, we’ll have the largest remaining numbers in descending order and the
 * smallest in ascending order at even and odd positions, respectively.
 *
 * Constraints:
   0 <= nums.length <= 10pow3
   1 <= nums[i] <= 10 pow 5

  inp = 1,2,3,4,5,6,7,8
  op = 8,1,7,2,6,3,5,4
 */
public class ReArrangeArray {
    public static int[] rearrangeArray(int[] nums) {

        int[] res = new int[nums.length];
        //New array of same size as input

        //iterate inp arry from both side
        //i =0, j= arr.length - 1,
        // set res[i]= inp[j] , res[i+1] = inp[i]
        // i++ , j--
        // i < j

        for (int i =0 , j = nums.length-1, k = 0; i <= j; i++,j--) {
            if ( i == j) {
                res[k] = nums[j];
            } else {
                res[k] = nums[j];
                res[k+1] = nums[i];
            }

            k = k+2;
        }

        // Replace this placeholder return statement with your code
        return res;
    }

    public static int[] rearrangeArray1(int[] nums) {
        int n = nums.length;
        if (n == 0) return nums;

        // Initialize pointers to the start and end of the array
        int maxIdx = n - 1;
        int minIdx = 0;
        // Initialize a variable larger than any element in the array to use for encoding
        int maxElem = nums[n - 1] + 1;

        // Encoding phase
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {  // Encoding at even indexes
                nums[i] += (nums[maxIdx] % maxElem) * maxElem;
                maxIdx--;
            } else {  // Encoding at odd indexes
                nums[i] += (nums[minIdx] % maxElem) * maxElem;
                minIdx++;
            }
        }

        // Decoding phase
        for (int i = 0; i < n; ++i) {
            nums[i] = nums[i] / maxElem;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] res = rearrangeArray1(new int[]{1,2,3,4,5,6});

        for (int val : res) {
            System.out.println("Value is " + val);
        }
    }
}
