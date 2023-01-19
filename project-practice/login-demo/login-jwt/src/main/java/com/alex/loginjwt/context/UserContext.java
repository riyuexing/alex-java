package com.alex.loginjwt.context;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 15:20
 */
public final class UserContext {
    private static final ThreadLocal<String> user = new ThreadLocal<String>();

    public static void add(String userName){
        user.set(userName);
    }

    public static void remove(){
        user.remove();
    }

    public static String getCurrentUserName(){
        return user.get();
    }

}
