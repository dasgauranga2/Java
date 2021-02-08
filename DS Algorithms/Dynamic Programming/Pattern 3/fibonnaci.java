
// Return the N-th fibonnaci number
public class fibonnaci {

    static int calls = 0;
    static Integer[] result;

    // given a number n
    // return the n-th fibonnaci number
    // public static int fib(int n) {
    //     calls++;

    //     if (n <= 1) {
    //         return 1;
    //     }

    //     return fib(n-1)+fib(n-2);
    // }

    public static int fib(int n) {
        calls++;

        if (n <= 1) {
            return 1;
        }

        if (result[n] != null) {
            return result[n];
        }

        result[n] = fib(n-1)+fib(n-2);
        return result[n];
    }

    public static void main(String[] args) {

        int N = 26;
        
        result = new Integer[N+1];
        int value = fib(N-1);
        
        System.out.println("N-TH FIBONNACI NUMBER : " + value);
        System.out.println(calls);
    }
}