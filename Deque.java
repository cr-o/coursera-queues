/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
    }

    // return the number of items on the deque
    public int size() {
    }

    // add the item to the front
    public void addFirst(Item item) {
    }

    // add the item to the back
    public void addLast(Item item) {
    }

    // remove and return the item from the front
    public Item removeFirst() {
    }

    // remove and return the item from the back
    public Item removeLast() {
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        public boolean hasNext() {
            return false;
        }

        public Item next() {
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
    }

}
