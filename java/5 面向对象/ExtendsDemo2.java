/**
 * 继承执行顺序
 *
 * @author: wangwenjie
 * @date: 2019-12-11
 */
public class ExtendsDemo2 extends Two{
    static {
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类构造代码块");
    }
    ExtendsDemo2(){
        /**
         * 父类静态代码块
         * 子类静态代码块
         * 父类构造代码块
         * 父类构造方法
         * 父类局部代码块
         * 子类构造代码块
         * 子类构造方法
         * 子类局部代码块
         */
        System.out.println("子类构造方法");
        {
            System.out.println("子类局部代码块");
        }
    }


    public static void main(String[] args) {
        new ExtendsDemo2();
    }
}

class Two{
    static {
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类构造代码块");
    }
    Two(){
        System.out.println("父类构造方法");
        {
            System.out.println("父类局部代码块");
        }
    }


}
