import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 使用增强for remove集合元素
 *
 * @author wangwenjie
 * @date 2019-12-17
 */
public class ForEachRemove {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {{
            add("string1");
            add("string2");
            add("string3");
            add("string1");
        }};

        /**
         * 不能再增强for中移除/添加集合元素
         *
         * 增强for相当于 do while 语法糖 ，遍历迭代器 ，使用集合remove方法移除，
         * 并不能改变expectedModCount的值，
         *
         * 如果确定只删除一次元素 ，可以使用，因为初始两个值相同
         */
        /*for (String string : list) {
            if("string1".equals(string)){
                list.remove(string);    //Exception in thread "main" java.util.ConcurrentModificationException
            }
        }*/

        /**
         * 使用iterator，调用iterator remove方法
         */
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            if("string1".equals(next)){
                iterator.remove();
            }
        }

        /**
         * 使用普通for循环remove 调用集合remove方法
         */

        for (int i = 0; i < list.size(); i++) {
            if ("string1".equals(list.get(i))) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
