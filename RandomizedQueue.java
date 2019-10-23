import java.util.Iterator;

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item first = null;

    private class Node {
        Item data;
        Node next;
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
    }

    // return the number of items on the randomized queue
    public int size() {
    }

    // add the item
    public void enqueue(Item item) {
    }

    // remove and return a random item
    public Item dequeue() {
    }

    // return a random item (but do not remove it)
    public Item sample() {
    }

    // return an independent iterator over items in random order
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
