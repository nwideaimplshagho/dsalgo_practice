package org.educative.heap.common;

import java.util.Arrays;

public class Heap {

    public void maxHeapify(int[] heapArray, int parentIdx) {
        int heapSize = heapArray.length;

        if (parentIdx < 0) {
            return;
        }

        int tempParentIdx = parentIdx;
        int midOfHeap = heapSize/2;
        while (tempParentIdx < midOfHeap) {
            int left = (tempParentIdx*2)+1;

            int max = Integer.MIN_VALUE;
            if (left < heapSize && heapArray[left] > heapArray[tempParentIdx]) {
                max = left;
            }
            int right = (tempParentIdx*2)+2;

            if (right < heapSize) {
                if ( max >= 0 && heapArray[right] > heapArray[max]) {
                    max = right;
                } else if ( max < 0 && heapArray[right] > heapArray[tempParentIdx]) {
                    max = right;
                }
            }

            if (max < 0) {
                break;
            }

            int tempMax = heapArray[max];
            heapArray[max] = heapArray[tempParentIdx];
            heapArray[tempParentIdx] = tempMax;

            tempParentIdx = max;
        }

        maxHeapify(heapArray, parentIdx-1);
    }

    public void buildMaxHeap(int[] heapArray, int heapSize)
    {
        // swap largest child to parent node
//        for (int i = (heapSize - 1) / 2; i >= 0; i--){
//            maxHeapify(heapArray, i, heapSize);
//        }
        maxHeapify(heapArray, (heapSize - 1)/2);
    }

    public void minHeapify(int[] heapArray, int parentIdx) {
        int heapSize = heapArray.length;

        if (parentIdx < 0) {
            return;
        }

        int tempParentIdx = parentIdx;
        int midOfHeap = (heapSize - 1)/2;
        while (tempParentIdx <= midOfHeap) {
            int left = (tempParentIdx*2)+1;

            int min = Integer.MAX_VALUE;
            if (left < heapSize && heapArray[left] < heapArray[tempParentIdx]) {
                min = left;
            }
            int right = (tempParentIdx*2)+2;

            if (right < heapSize) {
                if ( min < Integer.MAX_VALUE && heapArray[right] < heapArray[min]) {
                    min = right;
                } else if (min == Integer.MAX_VALUE && heapArray[right] < heapArray[tempParentIdx]) {
                    min = right;
                }
            }

            if (min == Integer.MAX_VALUE) {
                break;
            }

            int tempMax = heapArray[min];
            heapArray[min] = heapArray[tempParentIdx];
            heapArray[tempParentIdx] = tempMax;

            tempParentIdx = min;
        }

        minHeapify(heapArray, parentIdx-1);
    }

    public void buildMinHeap(int[] heapArray, int heapSize)
    {
        minHeapify(heapArray, (heapSize - 1)/2);
    }

    public static void main(String[] args) {
//        int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
//
//        System.out.println("Before heapify: "+ Arrays.toString(heapArray));
//        new Heap().buildMaxHeap(heapArray, heapArray.length);
//        System.out.println("After heapify: "+Arrays.toString(heapArray));
        int[] heapArray = { 5, 2, 9 ,-3, 7 };

        System.out.println("Before heapify: "+Arrays.toString(heapArray));
        new Heap().buildMinHeap(heapArray, heapArray.length);
        System.out.println("After heapify: "+Arrays.toString(heapArray));
    }

}
