package org.educative.hashtables.examples;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class FindSymmetric {
    public static List<List<Integer>> findSymmetric(int[][] arr) {
        Set<String> pairSet = new HashSet<>();
        List<List<Integer>> resultantSymetricPairs = new ArrayList<>();

        for (int idx = 0; idx < arr.length; idx++) {
            int first = arr[idx][0];
            int second = arr[idx][1];
            String pairSetVal = String.format("%s-%s",Integer.toString(Math.min(first,second)), Integer.toString(Math.max(first,second)));
            if (!pairSet.add(pairSetVal)) {
                resultantSymetricPairs.add(List.of(first, second));
            }
        }

        return resultantSymetricPairs;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
                {{1, 2}, {4, 6}, {4, 3}, {6, 4}, {5, 9}, {3, 4}, {9, 5}},
                {{1, 2}, {2, 1}, {3, 4}, {5, 5}, {6, 7}},
                {{1, 9}, {9, 1}},
                {{1, 2}, {3, 4}, {5, 6}},
                {{-8, -4}, {7, 7}, {1, 1}, {2, 2}, {-4, -8}}
        };

        int i = 1;
        for (int[][] testCase : testCases) {
//            log.info("{}.\tInput Array: {}",i , Arrays.deepToString(testCase));
            List<List<Integer>> symmetric = findSymmetric(testCase);
            log.info("\n\tSymmetric pairs: {} ", symmetric);
            log.info(new String(new char[100]).replace('\0', '-'));
            i++;
        }
    }
}
