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

    private class Node {
        Item data;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // return the number of items on the deque
    public int size() {
        int size = 0;
        if (first != null) {
            for (Item item : this) {
                size++;
            }
            // Iterator<Item> iterator = this.iterator();
            // while (iterator.hasNext()) {
            //     Item item = iterator.next();
            //     size++;
            // }
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
        if (first != null) {
            first.prev = newFirst;
        }
        first = newFirst;
        if (this.size() == 1) {
            last = first;
        }

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
        Node newFirst = first.next;
        Item oldFirstData = first.data;
        first = newFirst;
        first.prev = null;
        return oldFirstData;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size() == 0) {
            throw new NoSuchElementException("Cannot removeFirst, no such element exists");
        }
        Node newLast = last.prev;
        Item oldLastData = last.data;
        last = newLast;
        last.next = null;
        return oldLastData;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException("Cannot removeFirst, no such element exists");
            }
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

        deque.removeLast();

        deque.addLast(8);
        deque.removeFirst();
    }
}
