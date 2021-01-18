
public class if_statement {
    public static void main(String[] args) {
        
        int age = 23;

        // if-else statements
        if (age > 18) {
            System.out.println("You can drive");
        }
        else if (age == 18) {
            System.out.println("You can start driving");
        }
        else {
            System.out.println("You cannot drive");
        }
    }
}