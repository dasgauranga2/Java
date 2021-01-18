
public class try_and_catch {
    public static void main(String[] args) {
        
        // create an array of integers of size three
        int nums[] = new int[3];

        // handle exception
        // 'try' block executes a block of code
        // if an exception happens
        // the 'catch' block of code will be executed
        try {
            for (int i=0; i<4; i++) {
                nums[i] = i;
            }
        }
        catch (Exception e) {
            System.out.println("SOME ERROR HAPPEND");
            System.out.println(e.toString());
        }
    }
} 