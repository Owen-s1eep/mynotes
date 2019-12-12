/**
 * 内部类
 *  把类定义在类的内部就称为内部类，
 *
 *  内部类的访问特点：内部类可以直接访问外部类的成员，包括私有
 *                  外部类要访问内部类，先创建内部类的对象
 *
 *
 * @author: wangwenjie
 * @date: 2019-12-12
 */
public class InnerClassDemo {
    public static void main(String[] args) {
        /**
         * 访问外部类中的内部类
         *
         * Outer.Inner xxx = 外部类对象.内部类对象
         */
        Outer.Inner inner = new Outer().new Inner();
        inner.show();

        Outer outer = new Outer();
        outer.methods();
    }
}

class Outer {
    private int num = 10;

    //成员位置

    /**
     * 类定义在成员变量位置 为成员内部类
     */
    class Inner {

        public int q = 1;

        public void show() {
            System.out.println(num);
        }
    }

    /**
     * 如果内部类定义为私有，则不能直接访问show方法，需要借助外部类访问
     */
    public void methods(){
        Inner inner = new Inner();
        inner.show();
    }
}
