package org.educative.array;

/**
 * Implement a function that rearranges elements in an array so that all negative elements
 * appear to the left and all positive elements (including zero) appear to the right.
 * It’s important to note that maintaining the original sorted order of the input array
 * is not required for this task.
 *
 * Inp = 5,-2,7,3,0,8,0,-6
 * op = -2,-6,5,7,3,0,8,0
 *
 */
public class ReArrangePosNeg {

    public static void rearrange(int[] arr) {
        //Set a pointer for left mostPosEle, leftPosEle = 0
        //Iterate array
        // If arr[cur] < 0 and cur != leftPosEle then swap(arr[cur],arr[leftPosEle])
        // Increment leftPosEle++;
        for (int cur = 0, leftPosIdx = 0 ; cur < arr.length; cur++ ) {
            if (arr[cur] < 0) {
                if (leftPosIdx != cur) {
                    int temp = arr[leftPosIdx];
                    arr[leftPosIdx] = arr[cur];
                    arr[cur] = temp;
                }
                leftPosIdx++;
            }
        }
    }

    public static void main(String[] args) {
        int[] inp = new int[] {1,-2,3,-4,5};
        rearrange(inp);
        for(int val : inp) {
            System.out.println("Inp [" + val + "]");
        }
    }
}
