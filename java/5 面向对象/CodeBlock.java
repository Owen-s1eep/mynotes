/**
 * 代码块
 *
 * @author: wangwenjie
 * @date: 2019-12-11
 */
public class CodeBlock {
    static {
        /**
         * 只加载一次，类初始化
         */
        System.out.println("静态代码块");
    }

    {
        /**
         * 在构造方法前执行
         */
        System.out.println("构造代码块");
    }

    public CodeBlock(){
        System.out.println("构造方法 init");
    }

    public void select(){
        System.out.println("select methods ...");
        {
            System.out.println("局部代码块");
        }
        System.out.println("select end");
    }

    public static void main(String[] args) {
        /*
            静态代码块
            构造代码块
            构造代码块 2
            构造方法 init
            select methods ...
            局部代码块
            select end
            构造代码块
            构造代码块 2
            构造方法 init
         */
        CodeBlock cb = new CodeBlock();
        cb.select();
        new CodeBlock();

    }

    {
        System.out.println("构造代码块 2");
    }
}
