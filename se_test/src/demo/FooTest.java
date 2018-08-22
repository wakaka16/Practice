package demo;

public class FooTest {
    public static void main(String[] args) {
        FooInterface fooInterface = new FooImpl();
        fooInterface.method();
        FooInterface fooInterface1 = new FooExt();
        fooInterface1.method();
        FooImpl foo = new FooImpl();
        foo.method();
//        FooImpl
//        FooExt
//        FooImpl
    }
}
