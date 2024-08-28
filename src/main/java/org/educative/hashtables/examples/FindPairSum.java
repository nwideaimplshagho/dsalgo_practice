package org.educative.hashtables.examples;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class FindPairSum {
    public static int[] findSum(int[] arr, int n) {
        Set<Integer> numbers = new HashSet<>();
        for (int idx = 0; idx < arr.length; idx++) {
            numbers.add(arr[idx]);
        }

        for (int idx = 0; idx < arr.length; idx++) {
            if (numbers.contains(n-arr[idx])) {
                return new int[] {arr[idx],(n-arr[idx])};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 3, 4},
                {1, 2},
                {2, 2},
                {-4, -1, -9, 1, -7},
                {25, 50, 75, 100, 400}
        };

        int[] k = {5, 3, 4, -3, 425};

        for (int i = 0; i < inputs.length; i++) {
            log.info("{}.\tArray: {}", (i + 1), Arrays.toString(inputs[i]));
            log.info("\tk: {}" , k[i]);
            int[] result = findSum(inputs[i], k[i]);
            log.info("\n\t Result: {}", Arrays.toString(result));
            log.info(" {} ", '-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}
