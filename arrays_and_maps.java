import java.util.*;

public class arrays_and_maps {
    public static void main(String[] args) {
        
        // declare an array of integers
        int[] primes = {2,3,5,7,11,13};

        // access array element at index 2
        System.out.println(primes[2]);

        // length of the array
        System.out.println(primes.length);

        // create an array list
        List<Integer> list = new ArrayList<>();
        // add elements to the array list
        list.add(2);
        list.add(3);
        list.add(5);

        // acces the array element at index 2
        System.out.println(list.get(2));

        // create a map
        Map<Integer,String> map = new HashMap<>();

        // insert key-value pairs to a map
        map.put(1, "HELLO");
        map.put(7, "GREAT");
        map.put(2, "TIME'S UP");

        // access value using the key
        System.out.println(map.get(1));
    }
} 