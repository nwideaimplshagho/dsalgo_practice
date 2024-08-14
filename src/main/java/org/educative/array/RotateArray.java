package org.educative.array;

/**
 * Given an array, nums, and an integer, k, rotate the array to the right by k positions
 * so that each rotation involves shifting the elements one position at a time.
 *
 * inp = 10, 20, 30, 40 ,50
 * k = 3
 *
 * op = 30,40,50,10,20
 * i = 0 , 3
 */
public class RotateArray {

    public static int[] rightRotate(int[] nums, int k) {


        int[] res = new int[nums.length];

        for (int idx =0; idx < nums.length - k ; idx++) {
            res[idx + (k % nums.length)] = nums[idx];
        }

        for (int idx = nums.length - k ; idx < nums.length ; idx++) {
            res[(idx + (k % nums.length))%nums.length] = nums[idx];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] inp = new int[] {1,2,3,4,5};
        int[] res = rightRotate(inp,10);

        for (int val : res) {
            System.out.println("Value =" + val);
        }
    }
}
