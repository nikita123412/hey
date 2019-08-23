package config.byxml.beans;

public class E {
    private String eName;

    public E() {
    }

    public E(String eName) {
        this.eName = eName;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public void print() {
        System.out.println(this.eName);
    }
}
