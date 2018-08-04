package problems.p385;

import java.util.ArrayList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class Solution {

    public NestedInteger deserialize(String s) {
        return build(s.toCharArray(), 0, s.length());
    }

    private NestedInteger build(char[] chars, int start, int end) {
        if (start >= end) return null;
        if (chars[start] == '[') {
            NestedInteger number = new NestedInteger();
            int index = start + 1, bracket = 0;
            for (int i = start + 1; i < end; i++) {
                switch (chars[i]) {
                    case ',':
                        if (bracket == 0) {
                            number.add(build(chars, index, i));
                            index = i + 1;
                        }
                        break;
                    case '[':
                        bracket++;
                        break;
                    case ']':
                        bracket--;
                        break;
                }
            }
            NestedInteger num = build(chars, index, end - 1);
            if (num != null) {
                number.add(num);
            }
            return number;
        }
        return new NestedInteger(Integer.parseInt(String.valueOf(chars, start, end - start)));
    }
}

class NestedInteger {

    private int number;

    private List<NestedInteger> numbers;

    NestedInteger() {
        numbers = new ArrayList<>();
    }

    NestedInteger(int value) {
        this();
        number = value;
    }

    public boolean isInteger() {
        return numbers.isEmpty();
    }

    public Integer getInteger() {
        return this.number;
    }

    public void setInteger(int value) {
        this.number = value;
    }

    public void add(NestedInteger ni) {
        this.numbers.add(ni);
    }

    public List<NestedInteger> getList() {
        return this.numbers;
    }
}