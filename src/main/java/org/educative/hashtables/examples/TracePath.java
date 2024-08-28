package org.educative.hashtables.examples;

import java.util.*;

public class TracePath {

    public static List<List<String>> tracePath(List<List<String>> paths){
        List<List<String>> pathTraces = new ArrayList<>();
        Map<String, String> sourceDestMap = new HashMap<>();
        Map<String, String> destinationSourceMap = new HashMap<>();

        for(List<String> path : paths) {
            String source = path.get(0);
            String dest = path.get(1);

            sourceDestMap.put(source, dest);
            destinationSourceMap.put(dest, source);
        }

        String startingPoint = "";

        for (Map.Entry<String,String> sourceDestEntry: sourceDestMap.entrySet()) {
            String source = sourceDestEntry.getKey();
            if (!destinationSourceMap.containsKey(source)) {
                startingPoint = source;
                break;
            }
        }


        while (true) {
            String tempDestination = sourceDestMap.get(startingPoint);
            if (tempDestination != null && !tempDestination.isEmpty()) {
                pathTraces.add(List.of(startingPoint, tempDestination));
            } else {
                break;
            }
            startingPoint = tempDestination;
        }

        // Replace this placeholder return statement with your code
        return pathTraces;
    }

    public static List<List<String>> convertTo2DList(String[][] inputMaps) {
        List<List<String>> resultList = new ArrayList<>();

        for (String[] pair : inputMaps) {
            List<String> innerList = new ArrayList<>();
            innerList.add(pair[0]);
            innerList.add(pair[1]);
            resultList.add(innerList);
        }

        return resultList;
    }

    public static void main(String[] args) {
        String[][][] inputMaps = {
                {{"NewYork", "Chicago"}, {"Boston", "Texas"}, {"Missouri", "NewYork"}, {"Texas", "Missouri"}}
//                {{"Sydney", "Dubai"}, {"LosAngeles", "Cairo"}, {"Paris", "Rome"}, {"Cairo", "Paris"}, {"Rome", "Tokyo"}, {"Tokyo", "Sydney"}},
//                {{"Vienna", "Athens"}, {"London", "Berlin"}, {"Madrid", "Rome"}, {"Paris", "Vienna"}, {"Rome", "Paris"}, {"Athens", "Moscow"}, {"Berlin", "Madrid"}},
//                {{"Singapore", "Sydney"}},
//                {{"HongKong", "Taipei"}, {"Osaka", "Seoul"}, {"Taipei", "Singapore"}, {"Tokyo", "Osaka"}, {"Beijing", "Shanghai"}, {"Seoul", "Beijing"}, {"Singapore", "KualaLumpur"}, {"Shanghai", "HongKong"}}
        };


        TracePath tracePath = new TracePath();

        for (int i=0;i<inputMaps.length;i++) {

            List<List<String>> result = convertTo2DList(inputMaps[i]);
            List<List<String>> actual_output = tracePath.tracePath(result);

            System.out.println(Integer.toString(i+1)+". \tInput: " + Arrays.deepToString(inputMaps[i]));
            System.out.println("\tOutput: " + actual_output);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println();
        }
    }

}
