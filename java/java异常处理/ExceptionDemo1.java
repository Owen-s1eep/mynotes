public class ExceptionDemo1 {
    public void f() throws SimpleException{
        System.out.println("throw simpleException ");
        throw new SimpleException();
    }
    public static void main(String args[]){
        ExceptionDemo1 e1 = new ExceptionDemo1();
        try {
            e1.f();
        } catch (SimpleException e) {
            System.out.println("catch simple exception");
        }
    }
}

class SimpleException extends Exception {
}
