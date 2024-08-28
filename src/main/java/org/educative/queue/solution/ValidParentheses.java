package org.educative.queue.solution;

import lombok.extern.slf4j.Slf4j;
import org.educative.queue.common.MyStack;

/**
 * Statement
 *
 * Given a string, exp, which may consist of opening and closing parentheses. Your task is to check whether or not the string contains valid parenthesization.
 * The conditions to validate are as follows:
 * Every opening parenthesis should be closed by the same kind of parenthesis. Therefore, {) and [(]) strings are invalid.
 * Every opening parenthesis must be closed in the correct order. Therefore, )( and ()(() are invalid.
 *
 * Constraints:
 *
 * 1≤ exp.length ≤ 10^3
 *
 * The string will only contain the following characters: (, ), [, ], {, and }.
 */
@Slf4j
public class ValidParentheses {

    public static boolean isBalanced(String exp) {
        char[] expCharArr = exp.toCharArray();
        MyStack<Character> characterMyStack = new MyStack<>();

        for (int i = 0; i < expCharArr.length; i++) {
            char parenthesis = expCharArr[i];

            if (parenthesis == ' ') {
                continue;
            }

            if (isOpening(parenthesis)) {
                characterMyStack.push(parenthesis);
                continue;
            }

            if (isClosing(parenthesis)) {
                char closingParenthesis = getClosingForOpeningParenthesis(characterMyStack.pop());

                if (parenthesis != closingParenthesis) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isOpening(char parenthesis) {
        return switch (parenthesis) {
            case '(','{','[' -> true;
            default -> false;
        };
    }

    private static boolean isClosing(char parenthesis) {
        return switch (parenthesis) {
            case ')','}',']' -> true;
            default -> false;
        };
    }

    private static char getClosingForOpeningParenthesis(char parenthesis) {
        return switch (parenthesis) {
            case '('-> ')';
            case '{'-> '}';
            case '['-> ']';
            default -> ' ';
        };
    }

    public static void main(String[] args) {
        log.info("Result {}", isBalanced("{ { } } ( ) [ [ ] ]"));
    }
}
