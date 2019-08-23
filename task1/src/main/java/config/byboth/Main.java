package config.byboth;

import config.byboth.beans.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configForBoth.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        B b = (B) applicationContext.getBean("b");
        System.out.println("B-class a-value is: " + b.getA().getAName());
    }
}
