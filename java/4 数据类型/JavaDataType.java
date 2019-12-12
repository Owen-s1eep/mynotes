import java.util.Arrays;

/**
 * @Description: java基础数据类型
 * @Author: wangwenjie
 * @CreateTime: 2019-12-10 15:56
 */
public class JavaDataType {
    /*
        基本数据类型：byte short int long float double char boolean
            占用字节：1    2     4   8    4      8      2    1
            一个字节8bit
            byte取值范围2^8 -128~127
        引用数据类型：类 接口 数组

     */
    public static void main(String[] args) {
        {
            int i = 2147483647;
            long j = 2147483648L;
            long p = 1;
            float f = 1.2F;
            double d = 1.2;
            boolean flag;
        }

        //小转大 隐式转换
        {
            byte b = 1;
            int a = b;
            long l = b;
            byte b1 = 1 + 1;
            byte b2 = (byte) (a + 1);//大转小 ，强转
        }

        {
            /**
             * 变量相加先进行变量提升到int，不能直接赋值给byte
             */
            byte b1 = 3, b2 = 4, b;
            b = (byte) (b1 + b2);
            //常亮相加，判断结果是否在左边的取值范围，不在会报错
            b = 1 + 3;
        }

        {
            byte b = (byte) 129;
            System.out.println(b);
        }

        {
            short s = 1;
//            s = s + 1;
            s = (short) (s + 1);
            s += 1;//相当于上面的操作
        }

        {
            /**
             * 逻辑运算
             *  & 有false 则false
             *  | 有true 则true
             *  ^ 相同false 不同true
             *  ！ 取反
             * 位运算 先转换二进制 再进行运算
             *  & 有0 则0
             *  | 有1 则1
             *  ^ 相同为0 不同为1
             *  ~ 每个位置按位取反
             */
            /*
                3   00000011
                4   00000100
                &   00000000    0
                |   00000111    7
                ^   00000111    7
             */
            System.out.println(3 & 4);  //0
            System.out.println(3 | 4);  //7
            System.out.println(3 ^ 4);  //7
        }

        {
            /*
                同一数值^两次 ，值不变
                3   00000011
                3   00000011
                相同0 不同1
                ^   00000000
                1   00000001
                    00000001
             */
            System.out.println(1 ^ 3 ^ 3);//1
            System.out.println(4 ^ 2 ^ 4);//2
        }
        {
            //交换数值
            int a = 3, b = 4;
            a = a ^ b;
            b = a ^ b;//a ^ b ^ b = a
            a = a ^ b;//a ^ a ^ b = b
            System.out.println("a:" + a);
            System.out.println("b:" + b);
        }
        {
            int arr[] = {3, 2, 1, 5, 6};
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < i; j++) {

                    if (arr[j] > arr[j+1]) {
                        arr[j] = arr[j] ^ arr[j+1];
                        arr[j+1] = arr[j] ^ arr[j+1];
                        arr[j] = arr[j] ^ arr[j+1];
                    }
                }
            }
            System.out.println("array:" + Arrays.toString(arr));
        }
    }

}
