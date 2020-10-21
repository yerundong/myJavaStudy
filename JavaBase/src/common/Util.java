package common;

import java.lang.reflect.Array;

/**
 * @Description TODO
 * @Author 叶润东
 * @Date 2020/10/21
 * @Version 1.0
 */
public class Util {
    public String getType(Object obj){
        if(obj.getClass() == Byte.class){
            return "Byte";
        }else if(obj.getClass() == Short.class){
            return "Short";
        }else if(obj.getClass() == Integer.class){
            return "Integer";
        }else if(obj.getClass() == Long.class){
            return "Long";
        }else if(obj.getClass() == Double.class){
            return "Double";
        }else if(obj.getClass() == Float.class){
            return "Float";
        }else if(obj.getClass() == Character.class){
            return "Character";
        }else if(obj.getClass() == Boolean.class){
            return "Boolean";
        }else if(obj.getClass() == String.class){
            return "String";
        }else if(obj.getClass() == Array.class){
            return "Array";
        }else if(obj.getClass() == Class.class){
            return "Class";
        }
        return "";
    }
}
