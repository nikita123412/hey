package config.byclass;

import config.byclass.beans.A;
import config.byclass.beans.C;
import config.byclass.beans.D;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        A a1 = (A) applicationContext.getBean("a");
        A a2 = (A) applicationContext.getBean("a");
        C c = (C) applicationContext.getBean("c");
        D d = (D) applicationContext.getBean("d");
        a1.setAName("testAName1");
        a2.setAName("testAName2");

        System.out.println("A-class first bean's name is: " + a1.getAName());
        System.out.println("A-class second bean's name is: " + a2.getAName());
        System.out.println("C-class b-value name is: " + c.getB().getBName());
        System.out.println("D-class b-value name is: " + d.getB().getBName());
    }
}
