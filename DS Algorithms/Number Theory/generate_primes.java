
public class generate_primes {

    // SIEVE OF ERANTHOSES
    // GENERATE ALL PRIME NUMBERS FROM 1 TO A GIVEN NUMBER N
    // TIME COMPLEXITY : O(N*log(log(N)))
    public static void sieve(int n) {

        boolean[] primes = new boolean[n+1];
        for (int i=0; i<=n; i++) {
            primes[i] = true;
        }

        primes[0] = false;
        primes[1] = false;

        for (int i=2; i<=(int)Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j=2; i*j<=n; j++) {
                    primes[i*j] = false;
                }
            }
        }

        for (int i=0; i<primes.length; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        
        sieve(100);
    }
}