
class PassByValue {
    void calc(int i, int j) {
        i = i*2;
        j = j/2;
    }
}

class PassByReference {
    void calc(Test obj) {
        obj.x = obj.x*2;
        obj.y = obj.y/2;
    }
}

class Test {
    int x;
    int y;
}

public class pass_by_value_and_reference {
    public static void main(String[] args) {
        
        // PASS BY VALUE 
        PassByValue obj1 = new PassByValue();
        int a = 40, b = 20;

        System.out.println("a and b before method call " + a + " and " + b);
        // when we pass a primitive type argument to a method
        // it is passed by value
        obj1.calc(a,b);
        // the values will remain unchanged
        System.out.println("a and b after methods call " + a + " and " + b);

        // PASS BY REFERENCE 
        PassByReference obj2 = new PassByReference();
        Test o = new Test();
        o.x = 40;
        o.y = 20;

        System.out.println("x and y before method call " + o.x + " and " + o.y);
        // when we pass an object argument to a method
        // it is passed by reference
        obj2.calc(o);
        // the values will be changed
        System.out.println("x and by after methods call " + o.x + " and " + o.y);
    }
}