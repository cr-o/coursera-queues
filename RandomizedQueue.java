import java.util.Iterator;
import java.util.NoSuchElementException;

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

/*
What does “uniformly at random” mean? If there are n items in the randomized queue, then you should choose each one with probability 1/n, up to the randomness of StdRandom.uniform(), independent of past decisions. You can generate a pseudo-random integer between 0 and n − 1 using StdRandom.uniform(n).

How can I rearrange the entries of an array in uniformly random order? Use StdRandom.shuffle()—it implements the Knuth shuffle discussed in lecture and runs in linear time. Note that depending on your implementation, you may not need to call this method.

Can repeated calls to sample() in a randomized queue return the same item more than once? Yes, since you are sampling without removing the item. This is also known as “sampling with replacement.”

Should two iterators to the same randomized queue return the items in the same order? No, each iterator should have a different random order. This is what “independent iterators” means.

Why is it called a randomized queue if the items are not removed in first-in first-out order? This is a common name used in queueing theory.
*/
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
        if (randomizedQueue.length == size) {
            Item[] newQueue = (Item[]) new Object[size * 2];
            size = size * 2;
        }
        else {
            size++;
        }
        // add anywhere
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
        private int index = size;

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
