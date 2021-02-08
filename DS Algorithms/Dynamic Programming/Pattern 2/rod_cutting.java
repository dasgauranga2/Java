
// Given a rod of length n
// and an array of prices
// that contains prices of all rod pieces
// of length less than n
// Find the maximum prices that can be obtained
// by cutting the rod into smaller pieces
public class rod_cutting {

    static int calls = 0;
    static Integer[] result;

    // given the length of a rod
    // and the price for each smaller pieces
    // find the maximum amount that can be gained
    // by cutting the rod into smaller pieces
    // public static int rc(int[] prices, int length) {
    //     calls++;

    //     if (length == 0) {
    //         return 0;
    //     }

    //     int max_value = 0;
    //     // do this for each i=1 to length
    //     // cut the rod at length i
    //     // and find the maximum value from the rest of the rod
    //     // find the maximum and return it
    //     for (int i=1; i<=length; i++) {
    //         // max value obtained by cutting the rod at length i
    //         int value = prices[i-1]+rc(prices, length-i);
    //         max_value = Math.max(max_value, value);
    //     }

    //     return max_value;
    // }

    public static int rc(int[] prices, int length) {
        //calls++;

        if (length == 0) {
            return 0;
        }

        if (result[length] != null) {
            return result[length];
        }

        int max_value = 0;
        // do this for each i=1 to length
        // cut the rod at length i
        // and find the maximum value from the rest of the rod
        // find the maximum and return it
        for (int i=1; i<=length; i++) {
            // max value obtained by cutting the rod at length i
            int value = prices[i-1]+rc(prices, length-i);
            max_value = Math.max(max_value, value);
        }

        result[length] = max_value;
        return result[length];
    }
    
    public static void main(String[] args) {

        int[] PRICES = {1,5,8,9,10,17,17,20};
        int LENGTH = 4;
        
        result = new Integer[LENGTH+1];
        int max_value = rc(PRICES, LENGTH);
        
        System.out.println("MAXIMUM PROFIT : " + max_value);
        //System.out.println(calls);
    }
}