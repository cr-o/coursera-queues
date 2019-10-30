import java.util.Iterator;
import java.util.NoSuchElementException;

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] randomizedQueue;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 1;
        randomizedQueue = (Item[]) new Object[size];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return false;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        // add at beginning
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        // remove at random
        size--;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private int index;

        public boolean hasNext() {
            return index < randomizedQueue.length;
        }

        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        public Item next() {
            if (index >= randomizedQueue.length - 1) {
                throw new NoSuchElementException("Cannot removeFirst, no such element exists");
            }
            return randomizedQueue[index + 1];
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
    }
}
