/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Dequeue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;

    private class Node {
        Item data;
        Node next;
        Node previous;
    }

    // construct an empty deque
    public Dequeue() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // return the number of items on the deque
    public int size() {
        // iterate to get size
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot addFirst with illegal argument");
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot addFirst with illegal argument");
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size() == 0) {
            throw new NoSuchElementException("Cannot removeFirst, no such element exists");
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size() == 0) {
            throw new NoSuchElementException("Cannot removeFirst, no such element exists");
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current == null;
        }

        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        public Item next() {
            Item next = current.data;
            current = current.next;
            return next;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue<Int>();
    }
}
