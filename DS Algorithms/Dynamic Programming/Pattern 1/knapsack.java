
// Given the weights and profits of n items
// we have to put these items in a knapsack which 
// has a maximum capacity 
// We have to choose the subset of items which will be
// put so that the profits are maximized
// and the total weights of the items
// do not exceed the capacity of the knapsack
public class knapsack {

    static int calls = 0;
    static Integer[][] result;

    // given two integer arrays of profits and weights of n items
    // and the capacity of the knapsack
    // get the maximum profit
    // public static int ks(int[] profits, int[] weights, int capacity, int i) {
    //     calls++;

    //     if (capacity <= 0 || i >= profits.length) {
    //         return 0;
    //     }

    //     int profit1 = 0;
    //     // include the i-th item and get the profit
    //     if (weights[i] <= capacity) {
    //         profit1 = profits[i] + ks(profits, weights, capacity-weights[i], i+1);
    //     }
        
    //     // exclude the i-th item and get the profit
    //     int profit2 = ks(profits, weights, capacity, i+1);

    //     return Math.max(profit1,profit2);
    // }

    public static int ks(int[] profits, int[] weights, int capacity, int i) {
        //calls++;

        if (capacity <= 0 || i >= profits.length) {
            return 0;
        }

        if (result[capacity][i] != null) {
            return result[capacity][i];
        }

        int profit1 = 0;
        // include the i-th item and get the profit
        if (weights[i] <= capacity) {
            profit1 = profits[i] + ks(profits, weights, capacity-weights[i], i+1);
        }
        
        // exclude the i-th item and get the profit
        int profit2 = ks(profits, weights, capacity, i+1);

        result[capacity][i] = Math.max(profit1,profit2);
        return result[capacity][i];
    }

    public static void main(String[] args) {

        int[] PROFITS = {24,18,18,10};
        int[] WEIGHTS = {24,10,10,7};
        int CAPACITY = 25;
        
        result = new Integer[CAPACITY+1][PROFITS.length];
        int max_profit = ks(PROFITS,WEIGHTS,CAPACITY,0);
        
        System.out.println("MAXIMUM PROFIT : " + max_profit);
        //System.out.println(calls);
    }
}