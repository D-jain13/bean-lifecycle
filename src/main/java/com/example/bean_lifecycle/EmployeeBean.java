package com.example.bean_lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class EmployeeBean implements BeanNameAware, InitializingBean, DisposableBean {

    public EmployeeBean() {
        System.out.println("1. Constructor: HR created my employee ID. I haven't even seen the office yet!");
    }

    @Autowired
    public void setEnvironment(Environment env) {
        System.out.println("2. Dependency injection: Spring handed me my laptop and access card.");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("3. BeanNameAware: Spring gave me a name: " + name + ". At least someone knows who I am.");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("5. @PostConstruct: Onboarding complete. I now know where the coffee machine is!");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("6. afterPropertiesSet(): All dependencies are ready. Unfortunately, so is the workload.");
    }

    public void customInit() {
        System.out.println("7. custom initMethod: Team intro done. Everyone already forgot my name.");
    }

    public void doWork() {
        System.out.println("9. Business method: Writing production code. Hey, it works on my machine, apparently :).");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. @PreDestroy: Shutting down gracefully. Please don't assign me one last Jira ticket.");
    }

    @Override
    public void destroy() {
        System.out.println("11. DisposableBean.destroy(): Returning my laptop and access card.");
    }

    public void customDestroy() {
        System.out.println("12. custom destroyMethod: Exit interview done. Farewell cake was good.");
    }
}