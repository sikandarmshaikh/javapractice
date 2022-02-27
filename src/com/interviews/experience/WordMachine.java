package com.interviews.experience;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 
 * Zalando Codility Question
 * 
 * A word machine is a system that performs a sequence of simple operations on a
 * stack of integers. Initially the stack is empty. The sequence of operations
 * is given as a string. Operations are separated by single spaces. The
 * following operations may be specified: • an integer X (from 0 to 220 - 1):
 * the machine pushes X onto the stack; • "POP": the machine removes the topmost
 * number from the stack; • "DUP": the machine pushes a duplicate of the topmost
 * number onto the stack; • "+": the machine pops the two topmost elements from
 * the stack, adds them together and pushes the sum onto the stack; "-": the
 * machine pops the two topmost elements from the stack, subtracts the second
 * one from the first (topmost) one and pushes the difference onto the stack.
 * After processing all the operations, the machine returns the topmost value
 * from the stack. The machine processes 20-bit unsigned integers (numbers from
 * 0 to 220 - 1). An overflow in addition or underflow in subtraction causes an
 * error. The machine also reports an error when it tries to perform an
 * operation that expects more numbers on the stack than the stack actually
 * contains. Also, if, after performing all the operations, the stack is empty,
 * the machine reports an error. For example, given a string "13 DUP 4 POP 5 DUP
 * + DUP + -", the machine performs the following operations: operation comment
 * | stack - - - - - - - - - [empty] "13" push 13 12 "DUP" duplicate 13 "4" push
 * 4 "POP" pop 4 "5" push 5 duplicate 5 "DUP" 13, 13 13, 13, 4 13, 13 13, 13, 5
 * 13, 13, 5, 5 13, 13, 10 13, 13, 10, 10 13, 13, 20 | 13, 7 "+" add 5 and 5
 * "DUP" duplicate 10 add 10 and 10 subtract 13 from 20 Finally, the machine
 * will return 7. Given a string "5 6 + -", the machine reports an error, since,
 * after the addition, there is only one number on the stack, but the
 * subtraction operation expects two. Given a string "3 DUP 5 - -", the machine
 * reports an error, since the second subtraction yields a negative result.
 * Nrite a function: def solution (5) Chat, given a string S containing a
 * sequence of operations for the word machine, returns the result the machine
 * would return after processing the Operations. The function should return -1
 * if the machine would report an For example, given string S = "13 DUP 4 POP 5
 * DUP + DUP + "the function should return 7, as explained in the example above.
 * Given string S = "5 6 + -" or S = "3 DUP 5 - -" the function should return
 * -1. Assume that: • the length of S is within the range (0..2,000); • Sis a
 * valid sequence of word machine operations.
 *
 */

class Solution {

    public static final int MAX = 0xFFFFF;
    public static final int MIN = 0;
    private static final Pattern NUMERIC = Pattern.compile("\\d+");
    private final Stack<Integer> stack = new Stack<>();
    private static final Map<String, Runnable> OPERATIONS = new HashMap<>();
    {
        OPERATIONS.put("POP", this::pop);
        OPERATIONS.put("DUP", this::dup);
        OPERATIONS.put("+", this::add);
        OPERATIONS.put("-", this::sub);
    }

    public int solution(String S) {
        try {
            Arrays.stream(S.split(" ")).forEach(this::applyCommand);
            return pop();
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

        private void applyCommand(String s) {
        if (NUMERIC.matcher(s).matches()) {
            push(Integer.valueOf(s));
        } else {
            OPERATIONS.get(s).run();
        }
    }

    private void push(int i) {
        withinRange(i);
        stack.push(i);
    }

    private int pop() {
        return stack.pop();
    }

    private void dup() {
        hasElements(1);
        push(stack.peek());
    }

    private void add() {
        hasElements(2);
        push(stack.pop() + stack.pop());
    }

    private void sub() {
        hasElements(2);
        push(stack.pop() - stack.pop());
    }

    private int hasElements(int i) {
        if(stack.size() < i){
            throw new IllegalArgumentException("Too few elements available");
        }
        return i;
    }

    private int withinRange(int i){
        if(i < MIN || i > MAX){
            throw new IllegalArgumentException("Input under/overflow");
        }
        return i;
    }
}

