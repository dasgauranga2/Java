
public class gcd {

    // FIND THE GREATEST COMMON DIVISOR OF TWO GIVEN NUMBERS
    // TIME COMPLEXITY : O(log(min(a,b)))
    public static int find_gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return find_gcd(b, a%b);
    }

    public static void main(String[] args) {
        
        System.out.println(find_gcd(48, 36));
    }
}