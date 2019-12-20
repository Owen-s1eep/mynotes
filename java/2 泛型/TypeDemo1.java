import java.util.ArrayList;
import java.util.List;

/**
 * java 泛型
 *
 * @author wangwenjie
 * @date 2019-12-16
 */
public class TypeDemo1 {

    /**
     *  泛型只在编译阶段有效，编译阶段 正确校验泛型结果后会进行类型擦除
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        Class<? extends List> stringClass = stringList.getClass();
        Class<? extends List> integerClass = integerList.getClass();
        System.out.println(stringClass);    //class java.util.ArrayList
        System.out.println(integerClass);   //class java.util.ArrayList
    }
}
