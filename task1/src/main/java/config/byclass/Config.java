package config.byclass;

import config.byclass.beans.A;
import config.byclass.beans.B;
import config.byclass.beans.C;
import config.byclass.beans.D;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
    @Bean
    @Scope("prototype")
    public A a() {
        return new A();
    }

    @Bean
    public B b() {
        return new B();
    }

    @Bean
    public C c() {
        return new C();
    }

    @Bean
    public D d(B b) {
        return new D(b);
    }
}
