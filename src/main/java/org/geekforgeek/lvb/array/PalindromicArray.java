package org.geekforgeek.lvb.array;

/**
 * Given an array arr[] of positive integers. Return true if all the array elements are palindrome
 * otherwise, return false.
 *
 * Constraints:
 * 1 <=arr.size<= 20
 * 1 <=arr[i]<= 105
 *
 * Expected Time Complexity: O(nlogn)
 * Expected Space Complexity: O(1)
 *
 * Input: arr[] = [111, 222, 333, 444, 555]
 * Output: true
 * Explanation:
 * arr[0] = 111, which is a palindrome number.
 * arr[1] = 222, which is a palindrome number.
 * arr[2] = 333, which is a palindrome number.
 * arr[3] = 444, which is a palindrome number.
 * arr[4] = 555, which is a palindrome number.
 * As all numbers are palindrome so This will return true.
 *
 *
 * Input: arr[] = [121, 131, 20]
 * Output: false
 * Explanation: 20 is not a palindrome hence the output is false.
 *
 */
public class PalindromicArray {
    public static boolean palinArray(int[] arr) {
        boolean ret = true;
        ou: for (int i =0; i < arr.length; i++) {
            if(!isPalindromNumber(arr[i])) {
//                System.out.println("Num " + arr[i] + " is not palidrome");
                ret = false;
                break ou;
            }
        }
        return ret;
    }

    private static boolean isPalindromNumber(int num) {
        int reversedNum = 0;
        int orgNum = num;

        while (orgNum > 0) {
            int digit = orgNum % 10;
            reversedNum = reversedNum * 10 + digit;
            orgNum = orgNum/10;
        }

//        System.out.println("Reversed =" + reversedNum + ", num =" + num);
        return num == reversedNum;
    }

    public static void main(String[] args) {
        boolean plaindromArr = palinArray(new int[]{111,222,333});
        System.out.println(plaindromArr);
    }
}
