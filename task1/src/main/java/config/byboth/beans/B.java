package config.byboth.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class B {
    @Autowired
    private A a;

    public B() {
    }

    public A getA() {
        return a;
    }
}
