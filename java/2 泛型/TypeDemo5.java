/**
 * 泛型方法
 *
 * @author wangwenjie
 * @date 2019-12-17
 */
public class TypeDemo5 {

    /**
     * 泛型方法 public与返回值中间的<T>很重要，表示声明为一个泛型方法
     *
     * @param t
     * @param <T>
     * @return
     */
    public <T> T foo(T t) {
        return t;
    }

    public static void main(String[] args) {
        GenClass2<String> genClass2 = new GenClass2();
        genClass2.goo("aa");
        genClass2.eoo("bb");
        genClass2.goo(2);
        genClass2.eoo(2);
//        genClass2.foo(2);
    }
}

class GenClass2<T> {
    /**
     * 泛型方法的泛型可以与类一致 ，也可以不一致
     * 泛型方法中的泛型，虽然与类上泛型相同，但是类型可以传递不同
     * @param t
     * @param <T>
     * @return
     */
    public <T> T goo(T t) {
        return t;
    }

    public <E> E eoo(E e) {
        return e;
    }

    /**
     * 非泛型方法传递的泛型参数，与类一致，所以这里的T只能是String类型，其他类型校验不通过
     *
     * @author wangwenjie
     * @param t
     */
    public void foo(T t){
        System.out.println(t);
    }

    /**
     * 静态方法使用泛型，需要声明为泛型方法
     * @param t
     */
    public static <T> void koo(T t){
        System.out.println(t);
    }
}
