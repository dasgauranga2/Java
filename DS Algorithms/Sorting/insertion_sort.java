
public class insertion_sort {

    // INSERTION SORT
    // TIME COMPLEXITY : O(N^2)
    public static void sort(int[] nums) {

        for (int i = 1; i<nums.length; i++) {
            int key = nums[i];
            int j = i-1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int[] nums = {9,5,1,4,3,11,15,6};
        
        sort(nums);

        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}