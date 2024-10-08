package org.geekforgeek.lvb.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m, where both arrays may contain duplicate elements. The task is to determine whether array a2 is a subset of array a1. It's important to note that both arrays can be sorted or unsorted. Additionally, each occurrence of a duplicate element within an array is considered as a separate element of the set.
 *
 * Your Task:
 *  * You don't need to read input or print anything. Your task is to complete the function isSubset() which takes the array a1[], a2[], its size n and m as inputs and return "Yes" if arr2 is subset of arr1 else return "No" if arr2 is not subset of arr1.
 *  *
 *  *
 *  *
 *  * Expected Time Complexity: O(max(n,m))
 *  * Expected Auxiliary Space: O(n)
 *  *
 *  * Constraints:
 *  * 1 <= n,m <= 105
 *  * 1 <= a1[i], a2[j] <= 106
 * Example 1:
 *
 * Input:
 * a1[] = {11, 7, 1, 13, 21, 3, 7, 3}
 * a2[] = {11, 3, 7, 1, 7}
 * Output:
 * Yes
 * Explanation:
 * a2[] is a subset of a1[]
 *
 * Example 2:
 *
 * Input:
 * a1[] = {1, 2, 3, 4, 4, 5, 6}
 * a2[] = {1, 2, 4}
 * Output:
 * Yes
 * Explanation:
 * a2[] is a subset of a1[]
 *
 * Example 3:
 *
 * Input:
 * a1[] = {10, 5, 2, 23, 19}
 * a2[] = {19, 5, 3}
 * Output:
 * No
 * Explanation:
 * a2[] is not a subset of a1[]
 *
 *
 */
public class ArraySubset {

    public static String isSubset( long a1[], long a2[], long n, long m) {
        String subset = "False";
        Map<Long, Integer> numOccMap = new HashMap<>();
        //Find the bigger array
        //Push the array into a hashmap
        long[] arr;
        if (n >= m) {
            populateMap(a1, numOccMap);
            arr = a2;
        } else {
            populateMap(a2, numOccMap);
            arr = a1;
        }

        for (int i =0; i < arr.length; i++) {
            numOccMap.compute(arr[i], (num, count) -> count == null ? -1 : --count);
//            System.out.println("1 :: Key =" + arr[i] + ", value =" + numOccMap.get(arr[i]));
        }

        boolean isNumSubset = false;

        for (int i =0; i < arr.length; i++) {
//            System.out.println("2 :: Key =" + arr[i] + ", value =" + numOccMap.get(arr[i]));
            if (i == 0) {
                isNumSubset = numOccMap.get(arr[i]) >= 0;
            } else {
                isNumSubset = isNumSubset && numOccMap.get(arr[i]) >= 0;
            }
        }

        return isNumSubset ? "Yes" : "No";
    }

    private static void populateMap(long[] a1, Map<Long, Integer> numOccMap) {
        for (int i = 0; i < a1.length; i++) {
            numOccMap.compute(a1[i],(num, count) -> count == null ? 1 : ++count);
        }
    }

    public static void main(String[] args) {
//        System.out.println(" Resul =" + isSubset(new long[]{11, 7, 1, 13, 21, 3, 7, 3},new long[]{11, 3, 7, 1, 7}, 8 , 5 ));
        System.out.println(" Resul =" + isSubset(new long[]{10, 5, 2, 23, 19},new long[]{19, 5, 3}, 5 , 3 ));
    }

}
