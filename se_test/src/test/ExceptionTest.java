package test;

public class ExceptionTest {

public static  void test(String s){
    try{
        throw new RuntimeException();
    }catch (Exception e){
        throw new RuntimeException();
    }

}

    public static void main(String[] args) {
    test("The title is within 20 characters");
        System.out.println("hello");

    }

}
