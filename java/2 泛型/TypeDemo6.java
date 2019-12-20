/**
 * 泛型上下边界
 *
 * @author wangwenjie
 * @date 2019-12-20
 */
public class TypeDemo6 {
    public static void main(String[] args) {
        GenClass3<String> g3 = new GenClass3<>();
        //只能传入Number的子类
        g3.loo(new GenClass3<Integer>());
//        g3.loo(new GenClass3<String>());
        g3.moo(1);
        g3.poo(new GenClass3<Number>());


        GenClass4<Integer> g4 = new GenClass4<>();
        g4.noo(123);
        GenClass4<Double> genClass4 = new GenClass4<>();
        genClass4.noo(1.1);
    }
}

class GenClass3<T> {
    /**
     * 方法边界 Number的子类
     * @param value
     */
    public void loo(GenClass3<? extends Number> value){
        System.out.println(value);
    }

    /**
     * Number的父类
     * @param value
     */
    public void poo(GenClass3<? super Number> value){

    }

    /**
     * 泛型方法的边界
     * @param e
     * @param <E>
     */
    public <E extends Number> void moo(E e){

    }

}

/**
 * 类的边界
 * @param <T>
 */
class GenClass4<T extends Number>{
    public void noo(T t){

    }
}

