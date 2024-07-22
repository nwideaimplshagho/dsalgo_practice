package org.geekforgeek.lvb.array;

/**
 * Given an array arr, rotate the array by one position in clock-wise direction.
 *
 * Examples:
 *
 * Input: arr = [1, 2, 3, 4, 5]
 * Output: [5, 1, 2, 3, 4]
 * Explanation: If we rotate arr by one position in clockwise 5 come to the front and remaining those are shifted to the end.
 * Input: arr = [9, 8, 7, 6, 4, 2, 1, 3]
 * Output: [3, 9, 8, 7, 6, 4, 2, 1]
 * Explanation: After rotating clock-wise 3 comes in first position.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1<=arr.size()<=105
 * 0<=arr[i]<=105
 */
public class RotateArrayByOne {

    public void rotate(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int tempValue = arr[0];
        for (int i = 0 ; i < arr.length; i++) {
            //Find the new pos for current pos
            int newPos = (i + 1) % arr.length;
            //swap tempValue with newPos in arr
            int swapTemp = arr[newPos];
            arr[newPos] = tempValue;
            tempValue = swapTemp;

            if (newPos == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
//        int[] inpArr = new int[]{1, 2, 3, 4, 5};
        int[] inpArr = new int[]{9, 8, 7, 6, 4, 2, 1, 3};
        RotateArrayByOne rotateArrayByOne = new RotateArrayByOne();
        rotateArrayByOne.rotate(inpArr);

        for (int i =0 ; i < inpArr.length ;  i++) {
            System.out.println(" Value =" + inpArr[i] + ", index =" + i);
        }
    }
}
