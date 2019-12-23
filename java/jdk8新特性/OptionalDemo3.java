import org.junit.Assert;

import java.util.Optional;

/**
 * optional使用
 * 参考https://blog.kaaass.net/archives/764
 *
 * @author wangwenjie
 * @date 2019-12-23
 */
public class OptionalDemo3 {

    private static Q q = new Q();
    private static W w = new W();
    private static E e = new E();

    static {
        e.setName("e name");
        w.setE(e);
        q.setW(w);
    }

    /**
     * 案例
     *
     * @param dog
     * @return
     */
    public static String getName(Dog dog) {
        if (dog == null || dog.getName() == null)
            return "unknown";
        return dog.getName();
    }

    /**
     * 失败的改写方式
     *
     * @param dog
     * @return
     */
    public static String getNameByOptional(Dog dog) {
        Optional<Dog> dogOptional = Optional.ofNullable(dog);
        if (dogOptional.isPresent())
            return "unknown";
        return dogOptional.get().getName();
    }

    /**
     * 优雅的姿势
     *
     * @param dog
     * @return
     */
    public static String getNameByOptional2(Dog dog) {
        return Optional.ofNullable(dog)
                .map(d -> d.getName())
                .orElse("unknown");
    }

    public static void main(String[] args) {
        String eName = getENameByOptional(q);
        System.out.println(eName);
    }

    /**
     * 传统非空判断
     *
     * @param q
     * @return
     */
    public static String getEName(Q q) {
        if (q != null) {
            W w = q.getW();
            if (w != null) {
                E e = w.getE();
                if (e != null) {
                    return e.getName();
                }
            }
        }
        throw new IllegalArgumentException("The value of q is not available");
    }

    /**
     * Optional改造
     *
     * @param q
     * @return
     */
    public static String getENameByOptional(Q q) {
        return Optional.ofNullable(q)
                .map(Q::getW)
                .map(W::getE)
                .map(E::getName)
                .orElseThrow(() -> new IllegalArgumentException("The value of q is not available"));
    }
}

class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Q {
    private W w;

    public W getW() {
        return w;
    }

    public void setW(W w) {
        this.w = w;
    }
}

class W {
    private E e;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}

class E {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}