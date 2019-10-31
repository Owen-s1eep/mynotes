public class ExceptionController {
    public static void main(String args[]) {
        System.out.println("controller excute");
        ExceptionService service = new ExceptionService();
        try {
            service.f();
        } catch (Exception e) {
            System.out.println("controller handler exception");
            System.out.println("输出给前端接口的异常是：" + e.getMessage());
        }
        System.out.println("controller end");
    }
}

class ExceptionService {
    public void f() throws Exception {
        System.out.println("service excute");
        /*try {
            MyUtils.utilsFn();
        } catch (Exception e) {
            System.out.println("service handler exception");
            throw e;
        }*/
        MyUtils.utilsFn();
        System.out.println("service end");
    }
}

class MyUtils {
    public static void utilsFn() throws Exception {
        try {
            System.out.println("utils fn excute ...");
            throw new RuntimeException("这是utils抛出的异常 ，我要返回给前端接口");
        } catch (Exception e) {
            System.out.println("catch utils exception");
            /*
                使用throw抛出异常，写或者不写throws，上层都能够接受到这个异常，并且可以不对异常做任何处理
                但是如果方法上使用了throws 上层方法就必须处理异常，或者catch处理，或者向上抛出;
                注意：如果throws抛出的是RuntimeException或者其子类 ，可以允许不做处理
             */
            throw e;
        }
    }
}
