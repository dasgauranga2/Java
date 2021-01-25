import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Comparator;

class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer number1, Integer number2) {
        // elements are sorted in decreasing order
        if (number1 > number2) {
            return -1;
        }
        else if (number1 < number2) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

public class priority_queue_comparator {

    public static void main(String[] args) {

        // create a priority queue using a custom comparator
        // we implement a max priority queue
        PriorityQueue<Integer> nums = new PriorityQueue<>(new CustomComparator());

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