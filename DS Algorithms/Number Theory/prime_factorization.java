import java.util.ArrayList;

public class prime_factorization {

    // FIND ALL THE PRIME FACTORS OF A GIVEN NUMBER N
    // TIME COMPLEXITY : O(sqrt(N))
    public static void prime_factorize(int n) {

        ArrayList<Integer> result = new ArrayList<>();
        int original_number = n;

        for (int i=2; i<=(int)Math.sqrt(n); i++) {
            if (n%i == 0) {
                
                while (n%i == 0) {
                    n = n/i;
                    result.add(i);
                }
            }
        }
        if (n != 1) {
            result.add(n);
        }

        System.out.println("NUMBER : " + original_number + " PRIME FACTORS : " + result);
    }

    public static void main(String[] args) {
        
        for (int i=1; i<=100; i++) {
            prime_factorize(i);
        }
    }
}