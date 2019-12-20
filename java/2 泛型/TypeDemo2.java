/**
 * 泛型使用3种方式： 泛型类，泛型接口，泛型方法
 *
 * @author wangwenjie
 * @date 2019-12-16
 */
public class TypeDemo2 {
    public static void main(String[] args) {
        GenClass<String> genClass = new GenClass<>("a");
        GenClass genClass1 = new GenClass("b");
    }
}

/**
 * 泛型类 实例化泛型类
 */
class GenClass<T>{
    private T t;

//    public GenClass(){}

    public GenClass(T t){
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
