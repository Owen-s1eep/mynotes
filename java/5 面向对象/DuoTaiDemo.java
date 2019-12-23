import org.junit.Test;

/**
 * 多态相关
 *
 * @author wangwenjie
 * @date 2019-12-23
 */
public class DuoTaiDemo {

    @Test
    public void test(){
        Fu fu = new Fu();
        System.out.println(fu instanceof Fu);//true
        System.out.println(fu instanceof Zi);//false
        Fu fu1 = new Zi();
        System.out.println(fu1 instanceof Fu);//true
        System.out.println(fu1 instanceof Zi);//true
        Zi zi = new Zi();
        System.out.println(zi instanceof Fu);//true
        System.out.println(zi instanceof Zi);//true
    }
}

class Fu{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Zi extends Fu{

}
