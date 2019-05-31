package edu.utn.autos;

import edu.utn.autos.controller.AutoController;
import edu.utn.autos.model.Auto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        AutoController autoController = applicationContext.getBean(AutoController.class);
    }
}
