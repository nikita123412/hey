package config.byboth;

import config.byboth.beans.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:configForBoth.xml")
public class Config {
    @Bean
    public B b() {
        return new B();
    }
}
