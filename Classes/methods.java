
// defining a class
class Cube {
    // the class has three instance variables
    double width;
    double height;
    double depth;

    // class method
    double volume() {
       return width*height*depth;
    }
}

public class methods {
    public static void main(String[] args) {
        
        // create an object of the class
        Cube mybox = new Cube();
        double vol;

        // access the instance variables of the object
        mybox.width = 10;
        mybox.height = 20;
        mybox.depth = 15;

        // call the method of the object
        vol = mybox.volume();
        System.out.println("VOLUME OF CUBE : " + vol);
    }
}