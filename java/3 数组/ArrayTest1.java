import java.util.Arrays;

/**
 * @Description: array练习
 * @Auther: wangwenjie
 * @CreateTime: 2019-11-04
 */
public class ArrayTest1 {
    public static void main(String args[]) {
        System.out.println(Arrays.toString(getArray(3)));//[A@4554617c, A@74a14482, A@1540e19d]
    }

    /**
     * 接受一个int参数，返回一个和i相同大小的数组，并且填充对象
     *
     * @param n
     * @return
     */
    public static A[] getArray(int n) {
        A[] aa = new A[n];
        for (int i = 0; i < n; i++) {
            aa[i] = new A();
        }
        return aa;
    }
}

class A {

}