package org.geekforgeek.lvb.array;

import java.util.HashMap;

public class PairCount {
    int getPairsCount(int[] arr, int tar) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;

        for(int ele : arr)
            map.put(ele,map.getOrDefault(ele,0) + 1);

        for(int ele : arr){
            System.out.println("B element =" + ele + ", count =" + map.getOrDefault(ele,0));
            map.put(ele,map.getOrDefault(ele,0) - 1);
            System.out.println("A element =" + ele + ", count =" + map.getOrDefault(ele,0));
            ans += map.getOrDefault(tar - ele,0);
            System.out.println("ans =" + ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        PairCount pairCount = new PairCount();
        System.out.println("Restult =" + pairCount.getPairsCount(new int[] {1, 1, 1, 1}, 3));
    }
}
