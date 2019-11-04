import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 获取随机口味的icecream
 * @Auther: wangwenjie
 * @CreateTime: 2019-11-04
 */
public class IceCream {

    /*
        random参数47代表种子，每一个种子对应一个范围内的一个固定随机数，即
        random(47)+nextInt(10)多次执行的结果都是一样的，这里指的是获取一个随机值，
        但实际上，random是一个序列，种子seed代表获取数据的起始位置，每次获取完随机值，random的种子（seed）值会发生改变，
        下次获取的值依旧不同，
        如果不传递random参数，则默认为当前时间的毫秒值，随机的值是不一样的
     */
    private static Random random = new Random(47);

    static final String[] FLAVORS = {
            "口味1", "口味2", "口味3", "口味4", "口味5", "口味6", "口味7", "口味8", "口味9"
    };

    /**
     * 获取n种随机口味，并且n种口味不能重复
     *
     * @param n
     * @return
     */
    public static String[] flavorsSet(int n) {
        if (n > FLAVORS.length)
            //不合法参数异常
            throw new IllegalArgumentException("n is too big");
        //存放result结果集
        String[] result = new String[n];
        //存放口味选择标志
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int temp;
            do {
                //获取某个随机数
                temp = random.nextInt(FLAVORS.length);
            } while (picked[temp]);//当选择数组中含有这个值，则继续随机
            result[i] = FLAVORS[temp];
            picked[temp] = true;
        }
        return result;
    }

    public static void main(String args[]) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(flavorsSet(5)));
        }
    }
}
