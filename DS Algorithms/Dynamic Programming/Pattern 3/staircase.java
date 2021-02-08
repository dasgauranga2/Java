
// There are n stairs 
// and a person starting at the bottom
// wants to reach the top
// The person can climb either one or two steps at a time
// Count the number of ways the person can reach the top
public class staircase {

    static int calls = 0;
    static Integer[] result;

    // public static int sc(int n) {
    //     calls++;

    //     if (n == 0) {
    //         return 1;
    //     }
    //     if (n < 0) {
    //         return 0;
    //     }

    //     return sc(n-1)+sc(n-2);
    // }

    public static int sc(int n) {
        calls++;

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (result[n] != null) {
            return result[n];
        }
         
        result[n] = sc(n-1)+sc(n-2);
        return result[n];
    }

    public static void main(String[] args) {

        int N = 4;
        
        result = new Integer[N+1];
        int ways = sc(N);
        
        System.out.println("WAYS : " + ways);
        //System.out.println(calls);
    }
}