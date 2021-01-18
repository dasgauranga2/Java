
public class variable_scope {
    public static void main(String[] args) {
        
        // 'x' is declared inside main method
        // therefore, it can be accessed anywhere inside the 'main' method
        int x = 10;

        if(x == 10) {
            // 'y' is declared inside the 'if' block
            // therefore, it can only be accessed anywhere inside the 'if' block
            int y = 20;

            x = y*2;
        }
        // 'y' cannot be accessed outside the 'if' block
        // it will give an error
        // y = y+10;
        System.out.println(x);
    }
}