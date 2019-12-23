
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * jdk8的optional使用
 *  Optional中的filter方法可以过滤数据，map方法可以在返回对象前修改对象的属性
 *  构造函数：
 *      1.Optional.of(obj):要求传入的值不能为null，否则直接空指针异常
 *      2.Optional.ofNullable:可以传入null,返回Optional.empty(),否则返回Optional.of(obj)
 *      3.Optional.empty()  返回空的Optional
 *
 *  ifPresent:当不为null时执行
 *  filter：值为null，直接空指针异常，否则返回符合条件的值
 *  orElse：为null时可以设定默认值
 *
 *
 * @author wangwenjie
 * @date 2019-12-20
 */
public class OptionalDemo {

    private User user = new User();


    @Before
    public void before() {
        user.setName("张三");
    }

    /**
     * 创建空的Optional实例
     */
    @Test
    public void create1() {
        Optional<Object> empty = Optional.empty();
        Object o = empty.get();//java.util.NoSuchElementException: No value present
    }

    /**
     * 创建包含值的optional，如果传入为null，会throw 空指针异常
     * 不为null的时候使用of
     */
    @Test
    public void create2() {
        Optional<User> userOptional = Optional.of(this.user);
        User user = userOptional.get();
        System.out.println(user.getName());//张三
        Optional<Object> o = Optional.of(null);
    }

    /**
     * ofNullable 可以为空，返回一个Optional.empty空对象
     * 不为空就返回 Optional.of(obj)
     */
    @Test
    public void create3() {
        Optional<User> userOptional = Optional.ofNullable(this.user);
        Optional<Object> o = Optional.ofNullable(null);
    }

    /**
     * 获取Optional对象中的实例 通过get方法
     * 判断optional是否为空isPresent()
     */
    @Test
    public void get() {
        Optional<User> userOptional = Optional.ofNullable(this.user);
        //判断是否为空，不为空执行get获取实例
        Assert.assertTrue(userOptional.isPresent());
        User user = userOptional.get();
        Assert.assertEquals("张三", user.getName());
    }

    /**
     * 不为空执行方法
     */
    @Test
    public void ifPresent() {
        Optional<User> userOptional = Optional.ofNullable(this.user);
        /**
         * t不为空 ，执行
         */
        userOptional.ifPresent(user -> {
            System.out.println(user.getName());
        });
//        userOptional.get()
        Optional<Object> empty = Optional.empty();
        //为空是不执行的
        empty.ifPresent(e -> {
            System.out.println(e);
        });
    }

    /**
     * 返回默认值，ofNullable不为空则返回，为空返回orElse中的值
     */
    @Test
    public void returnDefault() {
        User user = null;
        User result = Optional.ofNullable(user).orElse(this.user);
        System.out.println(result.getName());//张三

        User user1 = new User("李四");
        User result2 = Optional.ofNullable(user1).orElse(this.user);
        System.out.println(result2.getName());//李四
    }

    /**
     * orElse和 orElseGet
     * <p>
     * orElse不管是否为空，都会执行orElse中的方法，而orElseGet只有为空时才执行
     */
    @Test
    public void orElseFn() {
        /**
         * 为空情况
         */
        Optional<User> optionUser = Optional.ofNullable(null);
        User orElseUser = optionUser.orElse(createUser());
        User orElseGetUser = optionUser.orElseGet(() -> createUser());
        System.out.println(orElseUser.getName());
        System.out.println(orElseGetUser.getName());
        /**
         * 调用创建对象方法
         * 调用创建对象方法
         * default User
         * default User
         */
        Optional<User> notNullOptional = Optional.ofNullable(this.user);
        User orElseUser1 = notNullOptional.orElse(createUser());
        User orElseGetUser1 = notNullOptional.orElseGet(this::createUser);
        System.out.println(orElseUser1.getName());
        System.out.println(orElseGetUser1.getName());
        /**
         * 调用创建对象方法
         * 张三
         * 张三
         */
    }

    /**
     * 返回异常 对象为空时抛出异常
     *
     * @return
     */
    @Test
    public void returnException() throws Exception {
        Object o = Optional.ofNullable(null).orElseThrow(() -> new IllegalArgumentException());//java.lang.IllegalArgumentException
        User user = Optional.ofNullable(this.user).orElseThrow(() -> new IllegalArgumentException());
        Optional.ofNullable(new User()).orElseThrow(() -> new IllegalArgumentException("参数异常"));
        Optional.ofNullable(this.user).orElseThrow(Exception::new);
    }

    /**
     * 映射，将optional中的值映射到一个新的optional中
     * map 函数
     *
     * map 会自动将值放到optional中，而flatMap需要手动创建Optional
     */
    @Test
    public void optionalMap() {
        String userName = Optional.ofNullable(this.user)
                .map(u -> user.getName()).orElse("default username");
        System.out.println(userName);
    }

    /**
     * flatMap 解除Optional包装的值
     *
     * @return
     */
    @Test
    public void flatMapTest() {
        this.user.setPosition("dev");
        String result = Optional.ofNullable(this.user).flatMap(u -> u.getPosition())
                .orElse("default position");
        System.out.println(result);
    }

    /**
     * filter
     *
     * @return
     */
    @Test
    public void filterTest() {
        Optional<User> optional = Optional.ofNullable(this.user);
        Assert.assertTrue(optional.isPresent());

        optional = optional.filter(u -> "张三".equals(u.getName()));
        User user = optional.get();
        System.out.println(user.getName());
    }

    public User createUser() {
        System.out.println("调用创建对象方法");
        return new User("default User");
    }

    public void print(String string) {
        System.out.println(string);
    }
}

class User {
    private String name;

    private String position;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

