import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 学生案例
 *
 * @author wangwenjie
 * @date 2019-12-23
 */
public class OptionalDemo2 {
    public List<Stu> initData() {
        Stu s1 = new Stu("张三", 19, 80);
        Stu s2 = new Stu("李四", 19, 50);
        Stu s3 = new Stu("王五", 23, null);
        Stu s4 = new Stu("赵六", 16, 90);
        Stu s5 = new Stu("钱七", 18, 99);
        Stu s6 = new Stu("孙八", 20, 40);
        Stu s7 = new Stu("吴九", 21, 88);
        return Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
    }

    /**
     * 找出年龄大于等于18岁，并且成绩大于80的人
     * java1.8之前的写法
     */
    @Test
    public void before8() {
        List<Stu> stus = initData();
        for (Stu stu : stus) {
            int age = stu.getAge();
            Integer score = stu.getScore();
            if (age >= 18 && score != null && score > 80) {
                System.out.println(stu.getName());
                //钱七
                //吴九
            }
        }
    }

    @Test
    public void after() {
        List<Stu> stus = initData();
        for (Stu stu : stus) {
            Optional<Stu> stuOptional = Optional.ofNullable(stu);
            Integer score = stuOptional.filter(s -> s.getAge() >= 18)
                    .map(Stu::getScore).orElse(0);
            if (score > 80) {
                System.out.println(stu.getName());
                //钱七
                //吴九
            }
        }
    }

    @Test
    public void after2() {
        List<Stu> stus = initData();
        for (Stu stu : stus) {
            Optional<Stu> stuOptional = Optional.ofNullable(stu);
            Optional<String> optional = stuOptional
                    .filter(s -> s.getAge() >= 18 && s.getScore() != null && s.getScore() > 80)
                    .map(Stu::getName);
            if (optional.isPresent()) {
                System.out.println(optional.get());
                //钱七
                //吴九
            }
        }
    }
}


class Stu {
    private String name;
    private int age;
    private Integer score;

    public Stu(String name, int age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
