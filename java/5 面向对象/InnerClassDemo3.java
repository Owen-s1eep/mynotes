/**
 * 局部内部类
 *
 * @author: wangwenjie
 * @date: 2019-12-12
 */
public class InnerClassDemo3 {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.show();
    }
}


class Outer2 {

    private int r = 13;

    public void show() {
        class Inner2{
            int e = 12;

            public void f(){
                System.out.println(e);
                System.out.println(r);
            }
        }

        Inner2 inner2 = new Inner2();
        inner2.f();
    }
}
