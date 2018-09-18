package com.smart.reflect;

public class ClassLoaderTest {
    public static void main(String[] args){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("now loader is " + loader);
        System.out.println("parent loader is " + loader.getParent());
        System.out.println("grandparent loader is " + loader.getParent().getParent());
    }
}

//AppClassLoader   ExtClassLoader   根加载器
