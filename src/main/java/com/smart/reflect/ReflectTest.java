package com.smart.reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable{
        //1.classloader
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.Car");

        //2.get default constructor and instance it
        Constructor cons = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car)cons.newInstance();

        //3.通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"BMW");
        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"red");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,345);
        return car;
    }
    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.say();
    }
}
