/**
 * 定义三种新的异常类型，在一个方法中抛出三种异常，在main中调用，仅用一个catch捕获三种异常
 */
public class ThinkingInJavaExceptionTest9 {
    public static void main(String args[]){
        try{
            f();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void f() throws Exception1, Exception2, Exception3 {
    }
}

class Exception1 extends Exception {
}

class Exception2 extends Exception {
}

class Exception3 extends Exception {
}


