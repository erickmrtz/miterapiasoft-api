package pe.edu.pucp.miterapia.util;

public abstract class MessageInfo {
    public static final String IS_OK = "OK";
    public static String is_null(Class object_name){
        return object_name.getSimpleName() + " is null";
    }
}
