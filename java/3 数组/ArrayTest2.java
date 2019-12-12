import java.util.Arrays;

/**
 * @Description:
 * @Author: wangwenjie
 * @CreateTime: 2019-12-11 09:06
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int arr[]) {
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = arr[i] ^ arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i] ^ arr[arr.length - 1 - i];
            arr[i] = arr[i] ^ arr[arr.length - 1 - i];
        }
    }
}
