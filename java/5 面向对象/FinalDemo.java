/**
 * final
 *
 * @author: wangwenjie
 * @date: 2019-12-11
 */
public class FinalDemo {


}

class Six{
    /**
     * final定义常量 需要在构造方法结束前进行赋值
     */
    final String Q;

    static {

        //静态代码块不能调用非静态
//        Q = "c";
    }


    {
        //构造代码块赋值
        Q = "b";
    }

    Six(){
//        Q = "b";
    }
    public void a(){
        //在方法不可赋值
//        Q = "aa";
    }
}
