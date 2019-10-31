import java.util.Arrays;

/**
 * @Description: 动态字段添加异常
 * @Auther: wangwenjie
 * @CreateTime: 2019-10-27
 */
public class DynamicFields {
    // 字段名称-字段值
    private Object[][] fields;

    /*
        初始化字段对象
     */
    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            //初始化fields
            fields[i] = new Object[]{null, null};
        }
    }

    /*
        判断是否存在name字段
     */
    private int hasFields(String name) {
        for (int i = 0; i < fields.length; i++) {
            if (name.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    /*
        获取字段下标
     */
    private int getFieldNumber(String name) throws NoSuchFieldsException {
        int fieldIndex = hasFields(name);
        if (fieldIndex == -1) {
            throw new NoSuchFieldsException();
        }
        return fieldIndex;
    }

    /*
        nice function

        为this.fields插入字段，当前数组先插入，如果没有空字段位置，则扩容一个新位置
     */
    private int makeField(String name) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = name;
                return i;
            }
        }
        // no empty fields, add one
        Object tmp[][] = new Object[fields.length + 1][2];
        //copy old array
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = fields[i];
        }
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[]{null, null};
        }
        fields = tmp;
        //再次调用方法 nice
        return makeField(name);
    }

    public Object getField(String name) throws NoSuchFieldsException {
        return fields[getFieldNumber(name)][1];
    }

    public Object setField(String name, Object value) throws DynamicFieldsException {
        if (value == null) {
            DynamicFieldsException dfe = new DynamicFieldsException();
            // 加入导致出现DynamicFields的原始异常是以为NullPointerException
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldsIndex = hasFields(name);
        if (fieldsIndex == -1) {
            fieldsIndex = makeField(name);
        }
        Object fieldValue = null;
        try {
            //获取值
            fieldValue = getField(name);
        } catch (NoSuchFieldsException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        fields[fieldsIndex][1] = value;
        return fieldValue;
    }

    public static void main(String args[]) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try {
            df.setField("d", "d value");
            df.setField("number", "47");
            df.setField("number2", "48");
            System.out.println(df);
            df.setField("number3", null);
            df.getField("number3");
        } catch (DynamicFieldsException e) {
            e.printStackTrace();
        } catch (NoSuchFieldsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(Arrays.toString(fields[i]));
        }
        return sb.toString();
    }
}


class NoSuchFieldsException extends Exception {

}

class DynamicFieldsException extends Exception {
}