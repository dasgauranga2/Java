import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer num1, Integer num2) {
        // elements are sorted in reverse order
        if (num1 > num2) {
            return -1;
        }
        else if (num1 < num2) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

public class collections_custom {

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(7);
        nums.add(2);
        nums.add(11);
        nums.add(13);
        nums.add(9);
        nums.add(6);
        nums.add(10);
        nums.add(4);

        // sort the collection using a custom comparator
        // here we sort in descending order
        Collections.sort(nums, new CustomComparator());

        System.out.println(nums);
    }
}