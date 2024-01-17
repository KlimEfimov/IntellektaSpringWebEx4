package com.example.intellektaspringwebex4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class IntellektaSpringWebEx4Application {

    public static void main(String[] args) {
        SpringApplication.run(IntellektaSpringWebEx4Application.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        SalesRepository salesRepository = context.getBean(SalesRepository.class);
//        salesRepository.count();
    }

}
