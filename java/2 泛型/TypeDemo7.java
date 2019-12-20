import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型数组
 *
 * @author wangwenjie
 * @date 2019-12-20
 */
public class TypeDemo7 {
    public static void main(String[] args) {
        /**
         * java中不能创建确定类型的泛型数组
         */
//        List<Integer> lists[] = new List<Integer>[10];
        //这样写可以
        List<Integer> lists[] = new List[10];
        List<?>[] ls = new List<?>[5];

    }

}
