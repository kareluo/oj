package problems.p284;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private boolean isPeek = false;

    private Integer value;

    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!isPeek) {
            value = iterator.next();
            isPeek = true;
        }
        return value;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (isPeek) {
            isPeek = false;
            return value;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return isPeek || iterator.hasNext();
    }
}