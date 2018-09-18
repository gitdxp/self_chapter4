package com.smart.beanfactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import com.smart.Car;
public class MyBeanPostProcessor implements BeanPostProcessor{
    public Object postProcessBeforeInitialization(Object bean,String beanName)
     throws BeansException{
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getColor() == null){
                System.out.println("call BeanPostProcessor.postProcessBeforeInitialization().");
                car.setColor("black1");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean,String beanName) throws BeansException{
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getMaxSpeed() >= 200){
                System.out.println("call BeanPostProcessor.post,,,afterinitial");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
