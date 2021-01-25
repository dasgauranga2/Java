import java.util.Iterator;
import java.util.PriorityQueue;

public class priority_queue {

    public static void main(String[] args) {

        // create a priority queue
        // by default it is a min priority queue
        PriorityQueue<Integer> nums = new PriorityQueue<>();

        // insert elements
        nums.add(7);
        nums.add(12);
        nums.add(3);
        nums.add(5);
        nums.add(6);
        nums.add(2);

        // access the head of the priority queue
        int head = nums.peek();
        System.out.println(head);

        // iterate over a priority queue
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" ");
        }
    }
}