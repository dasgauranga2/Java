import java.util.*;

// Given weights and values of n items
// we have to put these items in a knapsack
// of given capacity such that
// we get maximum total value
// Here we can break each item
// Therefore, it is also called
// fractional knapsack problem
public class knapsack {

    // class representing each item
    public static class Item {
        double weight;
        double value;
        // cost is value divided by weight
        Double cost;

        public Item(double w, double v) {
            weight = w;
            value = v;
            cost = value/weight;
        }

        @Override
        public String toString() {
            return "(" + value + " " + weight + " " + cost + ")";
        }
    }

    public static double ks(int[] values, int[] weights, int capacity) {
        
        // create a list of items
        LinkedList<Item> item_list = new LinkedList<>();
        for (int i=0; i<values.length; i++) {
            item_list.add(new Item(weights[i], values[i]));
        }
        // sort the list of items using the cost attribute
        Collections.sort(item_list, new Comparator<Item>(){
            @Override
            public int compare(knapsack.Item arg0, knapsack.Item arg1) {
                return arg1.cost.compareTo(arg0.cost);
            }
        });

        double total_val = 0d;
        // at each step we pick the item 
        // with the highest cost(value/weight)
        for (Item item : item_list) {
            
            double curr_value = item.value;
            int curr_weight = (int)item.weight;

            if (curr_weight <= capacity) {
                total_val = total_val+curr_value;
                capacity = capacity-curr_weight;
            }
            else {
                // if the weight of the item exceeds capacity
                // we pick only a fraction of the item as much as we can
                double fraction = (double)capacity/(double)curr_weight;
                total_val = total_val + fraction*curr_value;
                break;
            }
        }

        return total_val;
    }

    public static void main(String[] args) {

        int[] VALUES = {30,20,100,90,160};
        int[] WEIGHTS = {5,10,20,30,40};
        int CAPACITY = 60;

        double max_val = ks(VALUES, WEIGHTS, CAPACITY);

        System.out.println("MAXIMUM VALUE : " + max_val);
    }
}