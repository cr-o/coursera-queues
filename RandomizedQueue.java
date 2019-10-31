import edu.princeton.cs.algs4.StdRandom;

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
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (randomizedQueue.length == size) {
            doubleSize();
        }
        randomizedQueue[size++] = item;
    }

    private void doubleSize() {
        Item[] newQueue = (Item[]) new Object[size * 2];
        size = size * 2;
        for (int i = 0; i < size; i++) {
            newQueue[i] = randomizedQueue[i];
        }
        randomizedQueue = newQueue;
    }

    private void halveSize() {
        Item[] newQueue = (Item[]) new Object[size / 4];
        size = size / 4;
        for (int i = 0; i < size; i++) {
            newQueue[i] = randomizedQueue[i];
        }
        randomizedQueue = newQueue;
    }

    // remove and return a random item
    public Item dequeue() {
        if (randomizedQueue.length / 2 == size) {
            halveSize();
        }
        int i = StdRandom.uniform(0, size);
        Item toRemove = randomizedQueue[i];
        randomizedQueue[i] = randomizedQueue[size];
        size--;
        return toRemove;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        int i = StdRandom.uniform(0, size);
        return randomizedQueue[i];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private int index = 1;

        public boolean hasNext() {
            return index < size;
        }

        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        public Item next() {
            if (size == 0 || index == size - 1) {
                throw new NoSuchElementException("No more elements to return");
            }
            if (hasNext()) {
                index = StdRandom.uniform(0, size);
            }
            return randomizedQueue[index];
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

    }
}
