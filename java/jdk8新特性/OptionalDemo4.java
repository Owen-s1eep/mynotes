import org.junit.Test;

import java.util.Optional;

/**
 * optional使用
 *
 * @author wangwenjie
 * @date 2019-12-23
 */
public class OptionalDemo4 {
    public static void main(String[] args) {
        Animal animal = new PDD();
        animal.setName("pdd");
        System.out.println(animal instanceof PDD);  //true
        System.out.println(animal instanceof Animal);   //true
        PDD pdd = (PDD) animal;
        System.out.println(pdd.getName());

        String default_name = Optional.ofNullable(animal)
                .filter(a -> a instanceof PDD)
                .map(a -> (PDD) a)
                .map(PDD::getName)
                .orElse("default name");
        System.out.println(default_name);//pdd
    }

}

class Animal{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class PDD extends Animal{
}