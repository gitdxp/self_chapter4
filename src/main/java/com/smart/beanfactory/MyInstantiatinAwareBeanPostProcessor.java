package com.smart.beanfactory;
import java.beans.PropertyDescriptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import com.smart.Car;
public class MyInstantiatinAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessor {
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException{
        if("car".equals(beanName)){
            System.out.println("InstantiationAware BeanPostProcessor. postProcess BeforeInstantiation");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean,String beanName) throws BeansException{
        if("car".equals(beanName)){
            System.out.println("InstantiaitonAware BeanPsotProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    public PropertyValues postProcessProptertyValues(PropertyValues pvs, PropertyDescriptor[] pds,Object bean,String benaName)
     throws BeansException{
        if("car".equals(beanName)){
            System.out.println("Instantiation AwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }
}
