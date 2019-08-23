package config.byxml;

import config.byxml.beans.A;
import config.byxml.beans.B;
import config.byxml.beans.C;
import config.byxml.beans.D;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

        A a1 = (A) applicationContext.getBean("a");
        A a2 = (A) applicationContext.getBean("a");
        B b = (B) applicationContext.getBean("b");
        C c = (C) applicationContext.getBean("c");
        D d = (D) applicationContext.getBean("d");
        a1.setAName("testAName1");
        a2.setAName("testAName2");

        System.out.println("A-class first bean's name is: " + a1.getAName());
        System.out.println("A-class second bean's name is: " + a2.getAName());
        System.out.println("B-class name is: " + b.getBName());
        System.out.println("C-class name is: " + c.getCName());
        System.out.println("D-class e-value name is: " + d.getE().getEName());
    }
}
