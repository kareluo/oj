package problems.p155;

import java.util.Random;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        Stack<Integer> stack = new Stack<>();
        MinStack minStack = new MinStack();
        for (int i = 0; i < 1000; i++) {
            switch (random.nextInt(4)) {
                case 0:
                    int value = random.nextInt();
                    stack.push(value);
                    minStack.push(value);
                    break;
                case 1:
                    if (!stack.isEmpty()) {
                        stack.pop();
                        minStack.pop();
                    }
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        if (stack.peek() != minStack.top()) {
                            System.out.println("Top Value Not Equals");
                        }
                    }
                    break;
                case 3:
                    int min = Integer.MAX_VALUE;
                    for (Integer v : stack) {
                        if (v < min) {
                            min = v;
                        }
                    }
                    if (min != minStack.getMin()) {
                        System.out.println("MinValue Not Equals");
                    }
                    break;
            }
        }
    }
}
