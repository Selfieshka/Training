package ru.kpfu.itis.kirillakhmetov.work.reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class clazz = Class.forName("ru.kpfu.itis.kirillakhmetov.work.Test");
        Method method = clazz.getMethod("f");
        Object object = clazz.newInstance();
        System.out.println(method.invoke(object));
    }
}

class Test {
    int x = 5;
    public Test() {
    }

    public int f() {
        return x;
    }
}