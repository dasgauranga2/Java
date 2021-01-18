
public class for_each_loop {
    public static void main(String[] args) {

        int nums[] = {1,2,4,7,9};
        
        // for-each loop
        // iterate through each element of the array
        // in each iteration the array element value is stored in the variable 'x'
        for (int x : nums) {
            System.out.println(x);
        }
    }
}