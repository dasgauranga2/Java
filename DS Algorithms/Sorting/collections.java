import java.util.ArrayList;
import java.util.Collections;

public class collections {

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

        // sort the collection
        Collections.sort(nums);

        System.out.println(nums);
    }
}