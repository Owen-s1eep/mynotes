/**
 * @Description: finally中使用return
 * @Auther: wangwenjie
 * @CreateTime: 2019-10-28
 */
public class ExceptionFinally2 {

    public static void main(String args[]) {
        /*for (int i = 0; i <= 4; i++) {
            f(i);
        }*/
        try{
            throw new RuntimeException();
        }finally {
            //在finally中使用return 导致异常丢失
            return;
        }
    }

    public static void f(int i) {
        try {
            System.out.println("i : " + i);
            if (i == 0) return;
            if (i == 1) return;
            if (i == 2) return;
            if (i == 3) return;
            System.out.println("end ...");
            return;
        } finally {
            System.out.println("finally");//finally都会执行
        }
    }
}
