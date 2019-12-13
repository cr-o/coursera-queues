import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] randomizedQueue;
    private int rqSize;

    // construct an empty randomized queue
    public RandomizedQueue() {
        randomizedQueue = (Item[]) new Object[1];
        rqSize = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return rqSize == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        // Iterator<Item> it = this.iterator();
        // Item item;
        // while (it.hasNext()) {
        //     item = it.next();
        // }
        return rqSize;
    }

    // add the item
    public void enqueue(Item item) {
        if (randomizedQueue.length == rqSize) {
            doubleSize();
        }
        randomizedQueue[rqSize] = item;
        rqSize += 1;
    }

    private void doubleSize() {
        Item[] newQueue = (Item[]) new Object[randomizedQueue.length * 2];
        for (int i = 0; i < rqSize; i++) {
            newQueue[i] = randomizedQueue[i];
        }
        randomizedQueue = newQueue;
    }

    private void halveSize() {
        Item[] newQueue = (Item[]) new Object[randomizedQueue.length / 2];
        for (int i = 0; i < rqSize; i++) {
            newQueue[i] = randomizedQueue[i];
        }
        randomizedQueue = newQueue;
    }

    // remove and return a random item
    public Item dequeue() {
        if (rqSize == 0) {
            throw new NoSuchElementException("No more elements to dequeue");
        }
        if (randomizedQueue.length / 4 == rqSize) {
            halveSize();
        }
        int i = StdRandom.uniform(0, rqSize);
        Item toRemove = randomizedQueue[i];
        randomizedQueue[i] = randomizedQueue[rqSize - 1];
        randomizedQueue[rqSize - 1] = null;
        rqSize--;
        return toRemove;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (rqSize == 0) {
            throw new NoSuchElementException("No more elements to sample");
        }
        int i = StdRandom.uniform(0, rqSize);
        return randomizedQueue[i];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private int index;

        public boolean hasNext() {
            if (rqSize == 0) {
                throw new NoSuchElementException("No more elements to return");
            }
            index = StdRandom.uniform(0, rqSize);
            return index < rqSize;
        }

        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        public Item next() {
            if (hasNext()) {
                return randomizedQueue[index];
            }
            else {
                throw new NoSuchElementException("No more elements to return");
            }
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        assert (rq.isEmpty());
        rq.enqueue(0);
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);
        rq.enqueue(6);
        rq.enqueue(7);
        rq.enqueue(8);
        rq.enqueue(9);
        assert (rq.size() == 10);
        assert (!rq.isEmpty());
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        assert (rq.isEmpty());
    }
}
