/**
 * 泛型接口
 *
 * @author wangwenjie
 * @date 2019-12-17
 */
public class TypeDemo3 {
}

interface TypeInterface<T>{
    public T next();
}

/**
 * 未传入泛型实参时，与泛型类相同，在声明类的时候，需要将泛型的声明加入类
 *
 * class Gen1 ... 方式是错误的
 */
class Gen1<T> implements TypeInterface<T>{

    @Override
    public T next() {
        return null;
    }
}

/**
 * 传入泛型实参时，所有使用泛型的地方都要换为实参
 */
class Gen2 implements TypeInterface<String>{

    @Override
    public String next() {
        return null;
    }
}
