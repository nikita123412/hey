package config.byxml.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class D {

    @Autowired
    @Qualifier("e1")
    private E e;

    public D() {
    }

    public E getE() {
        return e;
    }
}
