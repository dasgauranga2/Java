import java.util.HashSet;

public class factors {

    // FIND ALL FACTORS OF A GIVEN NUMBER N
    // TIME COMPLEXITY : O(sqrt(N))
    public static void factorize(int n) {

        HashSet<Integer> result = new HashSet<>();
        
        for (int i=1; i<=(int)Math.sqrt(n); i++) {
            if (n%i == 0) {
                result.add(i);
                result.add(n/i);
            }
        }

        System.out.println("NUMBER : " + n + " FACTORS :" + result);
    }

    public static void main(String[] args) {
        
        for (int i=2; i<=100; i++) {
            factorize(i);
        }
    }
}