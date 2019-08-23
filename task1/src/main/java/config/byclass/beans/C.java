package config.byclass.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class C {
    @Autowired
    private B b;

    public C() {
    }

    public B getB() {
        return b;
    }
}
