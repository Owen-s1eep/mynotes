/**
 * @Description: 异常finally
 * @Auther: wangwenjie
 * @CreateTime: 2019-10-28
 */
public class ExceptionFinally {
    static int count = 0;

    public static void main(String args[]) {
        while (true) {
            try {
                if (count++ == 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("exception");
            } finally {
                System.out.println("finally");
                if (count == 2) {
                    break;
                }
            }
        }
    }
}
