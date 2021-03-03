package com.mycompany.ag2c;

import com.mycompany.ag2c.controller.MateriauxController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext= SpringApplication.run(App.class,args);

    }
}
