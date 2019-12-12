/**
 * java 继承
 *
 * @author: wangwenjie
 * @date: 2019-12-11
 */
public class ExtendsDemo extends One {

    private String five = "five sub";

    public ExtendsDemo(String one) {
        //调用父类构造方法
        super(one);
    }

    public ExtendsDemo() {
        //每个构造方法，默认调用父类无参构造
        super();
    }

    public void e() {
        /**
         * 不能继承父类的私有属性，和方法
         */
//        String one = this.one;
        String two = this.two;
        String three = this.three;
        String four = this.four;
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);

        System.out.println("super:" + super.five);
        System.out.println("sub:" + this.five);

    }

    public static void main(String[] args) {
        ExtendsDemo extendsDemo = new ExtendsDemo();
        extendsDemo.e();
    }
}

class One {
    //访问修饰符 public > protected> default >private
    private String one = "one";
    String three = "three";
    protected String two = "two";
    public String four = "four";

    String five = "five";

    public One() {

    }

    public One(String one) {
        this.one = one;
    }
}
