package com.example.bean_lifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class AuditBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof EmployeeBean) System.out.println("4. BeanPostProcessor (before init): HR compliance check before onboarding.");
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof EmployeeBean) System.out.println("8. BeanPostProcessor (after init): Badge issued. Spring could wrap me in a proxy here.");
        return bean;
    }
}