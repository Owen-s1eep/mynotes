/**
 * @Description: 重新抛出异常 不必为异常对象的清理担心，它们都是用new在堆上创建对象，垃圾回收器会自动清理
 * @Auther: wangwenjie
 * @CreateTime: 2019-10-27
 */
public class ReThrowExceptionDemo {
    public static void main(String args[]) {
        try {
            g();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            h();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f() throws Exception {
        throw new Exception("f抛出异常");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
//            throw new Exception("g抛出异常"); //捕获后抛出新的异常
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            //只把当前异常对象抛出，不会查询到源
            throw (Exception) e.fillInStackTrace(); //这是异常发生的起点，在捕获异常后抛出新的异常
        }
    }
}
