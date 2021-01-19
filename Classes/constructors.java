
// defining a class
class Cube {
    // the class has three instance variables
    double width;
    double height;
    double depth;

    // constructor for class
    // it is automatically called when an object of the class is created
    Cube(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // class method
    double volume() {
       return width*height*depth;
    }
}

public class constructors {
    public static void main(String[] args) {
        
        // create an object of the class
        // we pass parameters to the constructor
        Cube mybox = new Cube(20,15,25);
        double vol;

        // call the method of the object
        vol = mybox.volume();
        System.out.println("VOLUME OF CUBE : " + vol);
    }
}