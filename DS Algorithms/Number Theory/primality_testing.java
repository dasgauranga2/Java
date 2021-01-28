
public class primality_testing {

    // CHECK IF A GIVEN NUMBER IS PRIME
    // TIME COMPLEXITY : O(sqrt(N))
    public static boolean is_prime(int n) {

        for (int i=2; i<=(int)Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        for (int num=2; num<=100; num++) {
            if (is_prime(num)) {
                System.out.print(num + " ");
            }
        }
    }
}