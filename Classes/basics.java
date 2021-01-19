
// defining a class
class Box {
    // the class has three instance variables
    double width;
    double height;
    double depth;
}

public class basics {
    public static void main(String[] args) {
        
        // create an object of the class
        Box mybox = new Box();

        // access the instance variables of the object
        mybox.width = 10;
        mybox.height = 20;
        mybox.depth = 15;

        System.out.println("WIDTH : " + mybox.width);
        System.out.println("HEIGHT : " + mybox.height);
        System.out.println("DEPTH : " + mybox.depth);
    }
}