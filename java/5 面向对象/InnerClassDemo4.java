/**
 * 匿名内部类
 *
 * @author: wangwenjie
 * @date: 2019-12-12
 */
public class InnerClassDemo4 {
    public static void main(String[] args) {
        new Per().f(new Person1() {
            @Override
            public void show() {
                System.out.println("one show");
            }
        });
    }
}

interface Person1{
    void show();
}

class Per{
    public void f(Person1 p){
        p.show();
    }
}