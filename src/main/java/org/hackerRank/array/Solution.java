package org.hackerRank.array;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY stringList
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>(queries.size());

        Map<String, Integer> stringCountMap = new HashMap<>();
        stringList.forEach(s -> {
            stringCountMap.compute(s, (str, count) -> {
              if (count == null) {
                  return 1;
              } else {
                  return ++count;
              }
            });
        });

        queries.forEach(query -> {
            result.add(stringCountMap.getOrDefault(query,0));
        });

        return result;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int interMed = arr.get(0);
        int size = arr.size();
        Integer[] arrays = arr.toArray(new Integer[0]);

        for (int idx = 0; idx < arr.size(); idx++) {
            int newPos = (idx + size - d) % size;

            //swap arr[newPos] , interMed
            int swapTemp = arrays[newPos];
            arrays[newPos] = interMed;
            interMed = swapTemp;
        }

        return Arrays.asList(arrays);
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
//        Result.matchingStrings(List.of("aba", "baba", "aba", "xzxb"), List.of("aba","xzxb", "ab"));
        List<Integer> values = new ArrayList<>();
//        41 73 89 7 10 1 59 58 84 77 77 97 58 1 86 58 26 10 86 51
        values.add(41);
        values.add(73);
        values.add(3);
        values.add(4);
        values.add(5);
        Result.rotateLeft(4, values).forEach(System.out::println);
    }
}