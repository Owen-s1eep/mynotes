/**
 * 静态内部类
 *
 * @author: wangwenjie
 * @date: 2019-12-12
 */
public class InnerClassDemo2 {
    public static void main(String[] args) {
        /**
         * 创建方式
         */
        Outer1.Inner1 inner1 = new Outer1.Inner1();
        inner1.in();
    }
}

class Outer1 {

    static int w = 33;

    static class Inner1 {
        public void in() {
            System.out.println(w);
            System.out.println("内部类方法");
        }
    }
}
