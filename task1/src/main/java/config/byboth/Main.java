package config.byboth;

import config.byboth.beans.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        B b = (B) applicationContext.getBean("b");
        System.out.println("B-class a-value is: " + b.getA().getAName());
    }
}
