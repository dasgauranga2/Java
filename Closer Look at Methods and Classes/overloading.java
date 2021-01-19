
class OverloadClass {
    // method overloading
    // two or more methods have the same name
    // but, their parameter declarations are different
    void test() {
        System.out.println("No parameters");
    }

    void test(int a) {
        System.out.println("Parameter : " + a);
    }

    void test(int a,int b) {
        System.out.println("Parameters : " + a + " and " + b);
    }
}

public class overloading {
    public static void main(String[] args) {
        
        OverloadClass obj = new OverloadClass();

        // when a call to an overloaded method is encountered, 
        // the object simply executes the version of
        // the method whose parameters match the arguments used in the call
        obj.test();
        obj.test(6);
        obj.test(11,17);
    }
}