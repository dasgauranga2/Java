
class Factorial {
    // recursive method
    // the method calls itself
    int fact(int n) {
        if (n==1) {
            return 1;
        }

        return n*fact(n-1);
    }
}

public class recursion {
    public static void main(String[] args) {
        
        Factorial f = new Factorial();

        System.out.println("Factorial of 6 is : " + f.fact(6));
    }
}