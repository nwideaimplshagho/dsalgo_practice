package org.educative.queue.solution;

import lombok.extern.slf4j.Slf4j;
import org.educative.queue.common.MyQueue;

/**
 * Statement
 * Given a number n, generate a list of binary numbers from 1 to n in the form of a string using
 * a queue.
 *
 * Constraints:
 *
 * 1 ≤ n ≤ 1000
 */
@Slf4j
public class QueueFindBin {

    public static String[] findBin(int n) {
        String[] result = new String[n];
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.enqueue("1");

        for (int i=0 ; i < n; i++) {
            result[i] = myQueue.dequeue();

            String tempBin1 = result[i] + "0";
            String tempBin2 = result[i] + "1";

            myQueue.enqueue(tempBin1);
            myQueue.enqueue(tempBin2);
        }

        return result;
    }

    public static String[] findBin2(int n) {
        String[] result = new String[n];
        result[0] = "1";

        int binCalculationIdx = 0;// Idx element will be used to get next element by suffixing 0 and 1.
        int binCalcIdxChangeCounter = 0; // Will decide when to change the binCalculationIdx value.
                                            // Since next two indexes are generated using binCalculationIdx ,
                                            // so binCalcIdxChangeCounter % 2 == 0 the increment the index.

        for (int i=1 ; i < n; i++, binCalcIdxChangeCounter++) {
            if (binCalcIdxChangeCounter > 0 && binCalcIdxChangeCounter % 2 == 0) {
                binCalculationIdx+=1;
            }

            if (i % 2 == 0) {
                result[i] = result[binCalculationIdx] + "1";
            } else {
                result[i] = result[binCalculationIdx] + "0";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] result = findBin2(5);
        for (String val : result) {
            log.info("Value {}" , val);
        }
    }
}
