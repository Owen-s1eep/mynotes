/**
 * 多态
 *
 * @author: wangwenjie
 * @date: 2019-12-11
 */
public class ExtendsDemo4 extends Foo{
    public String n = "sub n";

    @Override
    public void foo() {
        System.out.println("sub foo");
    }

    public static void main(String[] args) {
        Foo e4 = new ExtendsDemo4();
        System.out.println(e4.n);//编译和运行看左边
        e4.foo();//编译看左边，运行看右边，因为方法重写了
        //n
        //sub foo
    }
}


class Foo{
    public String n = "n";

    public void foo(){
        System.out.println("foo");
    }
}
