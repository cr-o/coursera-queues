/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        Item data;
        Node next;
        Node prev;
    }

    private Node first;
    private Node last;

    // construct an empty deque
    public Deque() {
        first = new Node();
        last = new Node();
    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // return the number of items on the deque
    public int size() {
        int size = 0;
        if (first.data != null) {
            for (Item item : this) {
                size++;
            }
            // Iterator<Item> iterator = this.iterator();
            // Item item;
            // while (iterator.hasNext()) {
            //     item = iterator.next();
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

        if (first.data == null && last.data == null) { // deque is completely empty
            first = newFirst;
            last = newFirst;
        }
        else {
            Node temp = first;
            temp.prev = newFirst;
            first = newFirst;
            first.next = temp;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot addFirst with illegal argument");
        }
        Node newLast = new Node();
        newLast.data = item;
        if (first.data == null && last.data == null) { // deque is completely empty
            first = newLast;
            last = newLast;
        }
        else {
            Node temp = last;
            temp.next = newLast;
            last = newLast;
            last.prev = temp;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot removeFirst, no such element exists");
        }
        Item oldFirstData = first.data;
        if (first.next != null) {
            Node newFirst = first.next;
            first = newFirst;
            first.prev = null;
        }
        else {
            first.data = null;
            first.next = null;
            first.prev = null;
            last.data = null;
            last.next = null;
            last.prev = null;
        }
        return oldFirstData;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot removeFirst, no such element exists");
        }
        Item oldLastData = last.data;
        if (last.prev != null) {
            Node newLast = last.prev;
            last = newLast;
            last.next = null;
        }
        else {
            first.data = null;
            first.next = null;
            first.prev = null;
            last.data = null;
            last.next = null;
            last.prev = null;
        }
        return oldLastData;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
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

    /*
    To fix:
        size is 0 for first addLast and addFirsts
        addLast and and addFirsts are not connected to each other (prev/next)
    */
    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        System.out.printf("%d\n", deque.size());
        deque.addLast(7);
        System.out.printf("%d\n", deque.size());
        deque.addFirst(5);
        deque.addFirst(1);
        System.out.printf("%d\n", deque.size());
        assert (!deque.isEmpty());
        deque.addFirst(2);
        deque.addFirst(6);
        System.out.printf("%d\n", deque.size());
        deque.removeLast();

        deque.addLast(8);
        deque.removeFirst();
    }
}
