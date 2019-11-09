import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        if (args.length == 1) {
            int k = Integer.parseInt(args[0]);
            String string = "";
            RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
            while (!StdIn.isEmpty()) {
                string = StdIn.readString();
                randomizedQueue.enqueue(string);
            }
            string = "";
            while (k >= 0) {
                string = randomizedQueue.dequeue() + System.lineSeparator();
                System.out.print(string);
                k--;
            }

        }
    }
}
