/**
 * @Description: 栈轨迹
 * @Auther: wangwenjie
 * @CreateTime: 2019-10-27
 */
public class StackTraceDemo {
    public static void main(String args[]) {
        f();
        System.out.println("----------------------");
        g();
        System.out.println("----------------------");
        h();
    }

    public static void f(){
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                System.out.println(stackTraceElement.getMethodName());
            }
        }
    }
    static void g(){
        f();
    }
    static void h(){
        g();
    }
}
