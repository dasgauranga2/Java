
// defining a class
class Cuboid {
    // the class has three instance variables
    double width;
    double height;
    double depth;

    // class method
    double volume() {
       return width*height*depth;
    }

    // method with parameters
    void set_dimensions(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }
}

public class methods_with_parameters {
    public static void main(String[] args) {
        
        // create an object of the class
        Cuboid mybox = new Cuboid();
        double vol;

        // access the method of the object
        mybox.set_dimensions(15, 5, 20);

        // call the method of the object
        vol = mybox.volume();
        System.out.println("VOLUME OF CUBE : " + vol);
    }
}