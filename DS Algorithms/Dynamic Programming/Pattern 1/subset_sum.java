
// Given a set of positive numbers 
// determine if there exists a subset
// whose sum is equal to a given number
public class subset_sum {

    static int calls = 0;
    static Boolean[][] result;

    // given an integer array of positive numbers and a number
    // determine if there exists a subset whose sum
    // is equal to the given number
    // public static boolean ss(int[] nums, int sum, int i) {
    //     calls++;

    //     if (sum == 0) {
    //         return true;
    //     }
    //     if (i >= nums.length) {
    //         return false;
    //     }

    //     boolean r1 = false;
    //     // include the i-th number in the subset
    //     if (nums[i] <= sum) {
    //         r1 = ss(nums, sum-nums[i], i+1);
    //     }

    //     // exclude the i-th number in the subset
    //     boolean r2 = ss(nums, sum, i+1);

    //     return r1 || r2;
    // }

    public static boolean ss(int[] nums, int sum, int i) {
        //calls++;

        if (sum == 0) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }

        if (result[sum][i] != null) {
            return result[sum][i];
        }

        boolean r1 = false;
        // include the i-th number in the subset
        if (nums[i] <= sum) {
            r1 = ss(nums, sum-nums[i], i+1);
        }

        // exclude the i-th number in the subset
        boolean r2 = ss(nums, sum, i+1);

        result[sum][i] = r1 || r2;
        return result[sum][i];
    }

    public static void main(String[] args) {

        int[] NUMS = {3, 34, 4, 12, 5, 2};
        int SUM = 9;
        
        result = new Boolean[SUM+1][NUMS.length];
        boolean subset_exists = ss(NUMS,SUM,0);
        
        System.out.println("RESULT : " + subset_exists);
        //System.out.println(calls);
    }
}