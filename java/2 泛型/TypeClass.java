import java.util.Collection;

/**
 * @Description:
 * @Auther: wangwenjie
 * @CreateTime: 2019-11-01
 */
public class TypeClass {
    public static void main(String args[]) {
        Collection<Shape> shapes = null;
        f(shapes);
        Collection<Circle> circles = null;
//        f(circles);//编译不通过，需要使用泛型通配符 ? extends XXX
        Shape arr[] = new Circle[10];
        g(arr, new Shape());

//        h(new Circle());
    }

    //Shape或者Shape的子类
    public static void f(Collection<? extends Shape> shapes) {

    }

    public <T>  T g1(T t){
        return t;
    }

    //泛型static方法，T指定类型
    public static <T> void g(T arr[], T t) {

    }

    public static <T extends Comparable<? super T>> T h(T t){
        return t;
    }
}

class Shape implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Circle extends Shape {

}
