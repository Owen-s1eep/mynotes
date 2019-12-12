/**
 *  static关键字 this
 *
 * @author: wangwenjie
 * @createTime: 2019-12-11 09:32
 */
public class StaticVariable {
    private String name;

    private static String classNumber;

    /**
     * static 静态方法优先于类先加载到内存，this是随着对象创建而存在 ，
     * 先进内存的，不能访问后进内存的，后进的可以访问先进入内存的
     */
    public static void a(){
//        this.getName();
    }
    public void b(){
        a();
    }


    public StaticVariable(String name, String classNumber) {
        this.name = name;
        this.classNumber = classNumber;
    }

    public StaticVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getClassNumber() {
        return classNumber;
    }

    public static void setClassNumber(String classNumber) {
        StaticVariable.classNumber = classNumber;
    }

    public void getInfo() {
        System.out.println("name:" + getName() + " classnumber:" + getClassNumber());
    }

    public static void main(String[] args) {
        StaticVariable s1 = new StaticVariable("zs", "a0001");
        StaticVariable s2 = new StaticVariable("ls");
        s1.getInfo();
        s2.getInfo();
    }
}
