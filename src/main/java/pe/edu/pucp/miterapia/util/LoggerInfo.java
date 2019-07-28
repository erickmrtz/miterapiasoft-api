package pe.edu.pucp.miterapia.util;

public abstract class LoggerInfo {
    public static final String IS_NULL = "null";
    public static final String GET_METHOD = "Get Method";
    public static final String POST_METHOD = "Post Method";
    public static final String PUT_METHOD = "Put Method";

    public static String info(Class class_name, Class object_name, String reason){
        return "[" + class_name.getName() + " ------> " + object_name.getSimpleName() + " received is " + reason + "]";
    }

    public static String info(Class class_name, Class object_name){
        return "[" + class_name.getName() + " ------> " + object_name.getSimpleName() + " is being used]";
    }

    public static String info(Class class_name, String function_name){
        return "[" + class_name.getName() + " ------> " + function_name + " is being used]";
    }
}
