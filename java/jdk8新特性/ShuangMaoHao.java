import java.util.Optional;

/**
 * 双冒号
 * Java 8 中我们可以通过 `::` 关键字来访问类的构造方法，对象方法，静态方法。
 *
 * @author wangwenjie
 * @date 2019-12-23
 */
public class ShuangMaoHao {
    public static void main(String[] args) {
//        Co<String,String> co = Something::staticGet;
//        Something something = new Something();

        F f = new F();
        f.setName("f");
        String default_name = Optional.ofNullable(f)
                .map(u -> u.getName())
                .orElse("default name");
        //等价于
        String default_name1 = Optional.ofNullable(f)
                .map(F::getName)
                .orElse("default name");

        
    }
}

class F{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}




