/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private Deque<Item> deque;

    private class Node {
        Item data;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
        deque = new Deque<Item>();
    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // return the number of items on the deque
    public int size() {
        int size = 0;
        for (Item current : deque) {
            size++;
        }
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot addFirst with illegal argument");
        }
        Node newFirst = new Node();
        newFirst.data = item;
        newFirst.next = first;
        first.prev = newFirst;
        first = newFirst;

    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot addFirst with illegal argument");
        }
        Node newLast = new Node();
        newLast.data = item;
        last.next = newLast;
        newLast.prev = last;
        last = newLast;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size() == 0) {
            throw new NoSuchElementException("Cannot removeFirst, no such element exists");
        }
        Item oldFirstData = first.data;
        first = first.next;
        return oldFirstData;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size() == 0) {
            throw new NoSuchElementException("Cannot removeFirst, no such element exists");
        }
        Item oldLastData = last.data;
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
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(5);
        deque.addFirst(1);

        deque.addFirst(2);
        deque.addFirst(6);
    }
}
