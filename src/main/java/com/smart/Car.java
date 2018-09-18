package com.smart;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware, BeanNameAware,InitializingBean,DisposableBean{
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car(){
        System.out.println("调用Car()构造函数");
    }

    public Car(String brand, String color, int maxSpeed){
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException{
        System.out.println("调用BeanFactoryAware.setBeanFactory().");
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String beanName){
        System.out.println("调用BeanNameAware.setBeanName().");
        this.beanName = beanName;
    }

    public void afterPropertiesSet() throws Exception{
        System.out.println("调用InitalizingBean.afterPropertiesSet().");
    }

    public void destroy() throws Exception{
        System.out.println("调用DisposableBean.destroy().");
    }

    public void myInit(){
        System.out.println("调用init-method所指定的myInit(),将maxSpeed设置为230");
        this.maxSpeed = 230;
    }

    public void myDestroy(){
        System.out.println("调用destroy-method所指定的myDestroy().");
    }
    public void say(){
        System.out.println("brand:"+brand+"; color:"+color+"; maxSpeed:"+maxSpeed );
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
