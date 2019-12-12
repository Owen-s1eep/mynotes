/**
 * 方法重写
 *
 * @author: wangwenjie
 * @date: 2019-12-11
 */
public class ExtendsDemo3 extends Three{
    /**
     * 私有方法不能重写
     *
     * 父类静态方法，子类也必须静态重写
     */
    @Override
    void two() {
        //重写访问类型不能比父类更小
        System.out.println("sub two");
    }

    public static void three(){
        System.out.println("sub three");
    }
}

class Three{
    private void one(){
        System.out.println("one");
    }

    void two(){
        System.out.println("two");
    }

    public static void three(){
        System.out.println("three");

    }
}
