/**
 * 泛型通配符
 *
 * @author wangwenjie
 * @date 2019-12-17
 */
public class TypeDemo4 {
    public static void main(String[] args) {
        GenClass<Number> numberGenClass = new GenClass<Number>(456);
        set(numberGenClass);

        GenClass<Integer> integerGenClass = new GenClass<>(123);
//        set(integerGenClass);//cannot be applied


        setType(numberGenClass);
        setType(integerGenClass);
    }

    static void set(GenClass<Number> numberGenClass){
        System.out.println(numberGenClass.getT());
    }

    /**
     * GenClass<Integer>不能看做是GenClass<Number>的子类
     * 传入不同的泛型参数 ， 互相是不兼容的
     * 使用通配符方式  ？是一种类型实参，相当于Object，具体类型不确定时，使用？
     * @param genClass
     */
    static void setType(GenClass<?> genClass){
        System.out.println(genClass.getT());
    }

}


