package config.byxml.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class C {
    private String cName;

    @Autowired
    public C(String cName) {
        this.cName = cName;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }
}
