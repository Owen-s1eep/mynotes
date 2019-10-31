public class FullConstructors {
    public static void main(String args[]){
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void f() throws MyException {
        System.out.println("throw exception from f");
        throw new MyException();
    }
    public static void g() throws MyException {
        System.out.println("throw exception from g");
        throw new MyException("exception msg");
    }
}

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}
