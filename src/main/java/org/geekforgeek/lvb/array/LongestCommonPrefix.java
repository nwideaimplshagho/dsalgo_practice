package org.geekforgeek.lvb.array;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] arr) {

        if (arr == null || arr.length == 0) {
            return "-1";
        }

        if (arr.length == 1) {
            return arr[0];
        }

        // code here
        int longestStrIdx = 0;
        int matchingIdx = -1;
        for (int i = 0 , j = arr.length - 1 ; i < j; ) {
            if (arr[i] == null || arr[i].isEmpty()) {
                continue;
            }

            if (arr[j] == null || arr[j].isEmpty()) {
                continue;
            }

            //When i == 0 , Find the longer string MAX(a[i].length,a[i+1].length), set longestStrIdx
            longestStrIdx = getLongestIndex(arr, i, j);

            //compare a[longestStrIdx] vs a[i] , set matchingIdx
            if ( matchingIdx < 0) {
                matchingIdx = Integer.max(getMatchingIndex(arr[longestStrIdx], arr[longestStrIdx != j ? j : i]),matchingIdx);
            } else {
                matchingIdx = Integer.min(getMatchingIndex(arr[longestStrIdx], arr[longestStrIdx != j ? j : i]),matchingIdx);
            }


            if (longestStrIdx == i) {
                j--;
            } else {
                i++;
            }
        }

        return matchingIdx > 0 ? arr[longestStrIdx].substring(0,matchingIdx) : "-1";
    }

    private int getLongestIndex(String[] arr, int i, int j) {
        return  arr[i].length() >= arr[j].length() ? i : j;
    }

    private  int getMatchingIndex(String longestStr, String currentStr) {
        int matchingIdx = 0;
        int counter = 0;
        while (counter < currentStr.length()) {
            if (longestStr.charAt(counter) == currentStr.charAt(counter) ) {
                matchingIdx++;
            } else {
                break;
            }
            counter++;
        }

        return matchingIdx;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"geeksforgeeks", "geeks", "geek", "geezer"}));
//        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"rn","an","nmkhjqc","h","wsttodxva"}));
    }
}
