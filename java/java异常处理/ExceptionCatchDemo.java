/**
 * @Description: catch匹配最近的异常后就认为异常得到了处理，就不会再往下查找了
 * @Auther: wangwenjie
 * @CreateTime: 2019-10-28
 */
public class ExceptionCatchDemo {
    public static void main(String args[]){
        try{
            String string = null;
            string.toString();
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (RuntimeException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
