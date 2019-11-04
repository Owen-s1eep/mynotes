/**
 * @Description:
 * @Auther: wangwenjie
 * @CreateTime: 2019-11-01
 */
public class DiGui {
    public static void main(String args[]) {
//        System.out.println(12 % 10);
//        System.out.println(2 % 10);
//        System.out.println(123 / 10);
        printNum(123456);
        Person[] p = new Emp[10];
        p[0] = new Student();

    }

    public static void printNum(long i) {
        if (i >= 10)
            printNum(i / 10);
        System.out.print(i % 10 + ",");
    }
}

class Person {

}

class Student extends Person {

}

class Emp extends Person {

}
