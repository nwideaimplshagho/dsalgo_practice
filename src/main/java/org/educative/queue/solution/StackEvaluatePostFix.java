package org.educative.queue.solution;

import lombok.extern.slf4j.Slf4j;
import org.educative.queue.common.PostFixEvaluationStack;

/**
 * Statement
 * Given a string, exp, represents an arithmetic expression in a postfix notation. Evaluate exp and return the resulting integer value.
 *
 * The rules are given below:
 *
 * The valid operators are '+', '-', '*', and '/'.
 *
 * Each operand may be an integer or another expression.
 *
 * The division between two integers always truncates toward zero.
 *
 * There will not be any division by zero.
 *
 * The input represents a valid arithmetic expression in a postfix notation.
 *
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 * Each digit is considered to be a separate number, i.e., there are no double digit numbers.
 *
 * Constraints:
 *
 * 1 ≤ exp.length ≤ 10^3
 *
 *
 * exp[i] is either an operator or an integer in the range [0, 9]
 */
@Slf4j
public class StackEvaluatePostFix {

    public static int evaluatePostFix(String expression) {
        // Create an instance of Operand stack
        PostFixEvaluationStack<Integer> postFixEvaluationStack = new PostFixEvaluationStack<>();

        // iterate through the expression using indexOf where index < expression.size
        char[] expCharArr = expression.toCharArray();

        for (int idx = 0; idx < expression.length(); idx++) {
            char expChar = expCharArr[idx];

            if ( expChar == ' ') {
                continue;
            }
            // when ever we encounter operand push to stack
            if (isOperand(expChar)) {
                postFixEvaluationStack.push(Integer.parseInt(expChar+""));
                continue;
            }
            // When char is an operator then do following -

            if (isOperator(expChar)) {
                // pop top two elements from stack
                // always top will second  and next top will be first operand
                if (postFixEvaluationStack.isEmpty()) {
                    continue;
                }
                int secondOperand = postFixEvaluationStack.pop();
                if (postFixEvaluationStack.isEmpty()) {
                    continue;
                }
                int firstOperand = postFixEvaluationStack.pop();
                // do the operation
                // push the result back to stack
                postFixEvaluationStack.push(evaluate(firstOperand, secondOperand, expChar));
            }
        }

        return postFixEvaluationStack.pop();
    }

    private static int evaluate(int firstOperand, int secondOperand, char operator) {
        return switch (operator) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            case '/' -> firstOperand / secondOperand;
            default -> throw new RuntimeException("Invalid operator");
        };
    }

    private static boolean isOperand (char operand) {
        return switch (operand) {
            case '1','2','3','4','5','6','7','8','9' -> true;
            default -> false;
        };
    }

    private static boolean isOperator (char operator) {
        return switch (operator) {
            case '+','-','*','/' -> true;
            default -> throw new RuntimeException("Invalid operator");
        };
    }

    public static void main(String[] args) {
//        log.info("Result {}", StackEvaluatePostFix.evaluatePostFix("9 2 1 * - 8 - 4 +"));
//        log.info("Result {}", StackEvaluatePostFix.evaluatePostFix("5 4 3 - 3 * +"));
        log.info("Result {}", StackEvaluatePostFix.evaluatePostFix("8 2 / 3 - 3 1 * +"));
    }

}
