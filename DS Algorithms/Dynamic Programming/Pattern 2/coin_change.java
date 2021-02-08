
// Given a value n 
// and an infinite supply of given coin denominations 
// how many ways can we
// make change of value n using the coins
public class coin_change {

    static int calls = 0;
    static Integer[][] result;

    // given a number sum 
    // and an infinite supply of coins
    // how many ways we can make the change
    // public static int cc(int[] coins, int sum, int i) {
    //     calls++;
    //     if (sum == 0) {
    //         return 1;
    //     }
    //     if (i >= coins.length) {
    //         return 0;
    //     }

    //     // count ways to make the change which includes the i-th coin
    //     int count1 = 0;
    //     if (coins[i] <= sum) {
    //         count1 = cc(coins, sum-coins[i], i);
    //     }
        
    //     // count ways to make the change which excludes the i-th coin
    //     int count2 = cc(coins, sum, i+1);

    //     return count1+count2;
    // }

    public static int cc(int[] coins, int sum, int i) {
        //calls++;
        if (sum == 0) {
            return 1;
        }
        if (i >= coins.length) {
            return 0;
        }

        if (result[sum][i] != null) {
            return result[sum][i];
        }

        // count ways to make the change which includes the i-th coin
        int count1 = 0;
        if (coins[i] <= sum) {
            count1 = cc(coins, sum-coins[i], i);
        }
        
        // count ways to make the change which excludes the i-th coin
        int count2 = cc(coins, sum, i+1);

        result[sum][i] = count1+count2;
        return result[sum][i];
    }

    public static void main(String[] args) {

        int[] COINS = {2,5,8};
        int N = 10;
        
        result = new Integer[N+1][COINS.length+1];
        int ways = cc(COINS,N,0);
        
        System.out.println("WAYS : " + ways);
        //System.out.println(calls);
    }
}