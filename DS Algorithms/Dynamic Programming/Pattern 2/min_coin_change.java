
// Given a value n 
// and an infinite supply of given coin denominations 
// what is the minimum number
// of coins to make the change
public class min_coin_change {

    static int calls = 0;
    static Integer[] result;

    // given a number sum 
    // and an infinite supply of coins
    // what is the minimum no. of coins
    // required to make the change
    // public static int mcc(int[] coins, int sum) {
    //     calls++;

    //     if (sum == 0) {
    //         return 0;
    //     }

    //     int min_coins = Integer.MAX_VALUE;
    //     for (int x : coins) {
    //         if (x <= sum) {
    //             min_coins = Math.min(min_coins, 1 + mcc(coins,sum-x));
    //         }
    //     }
        
    //     return min_coins;
    // }

    public static int mcc(int[] coins, int sum) {
        //calls++;

        if (sum == 0) {
            return 0;
        }

        if (result[sum] != null) {
            return result[sum];
        }

        int min_coins = Integer.MAX_VALUE;
        for (int x : coins) {
            if (x <= sum) {
                min_coins = Math.min(min_coins, 1 + mcc(coins,sum-x));
            }
        }
        
        result[sum] = min_coins;
        return result[sum];
    }

    public static void main(String[] args) {

        int[] COINS = {25, 10, 5};
        int N = 30;
        
        result = new Integer[N+1];
        int min_coins = mcc(COINS,N);
        
        System.out.println("MIN COINS : " + min_coins);
        //System.out.println(calls);
    }
}