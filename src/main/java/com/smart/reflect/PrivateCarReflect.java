package com.smart.reflect;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.PrivateCar");
        PrivateCar pcar = (PrivateCar) clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        //取消java语言访问检查以访问private变量
        colorFld.setAccessible(true);
        colorFld.set(pcar,"red");

        Method drive = clazz.getDeclaredMethod("drive",(Class[])null);

        //取消java语言访问检查以访问protected方法
        drive.setAccessible(true);
        drive.invoke(pcar,(Object[])null);
    }
}
