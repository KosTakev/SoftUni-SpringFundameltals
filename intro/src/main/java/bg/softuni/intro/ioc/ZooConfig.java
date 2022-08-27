package bg.softuni.intro.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class ZooConfig {

    @Bean("cat")
    public Animal cat() {
        return new Cat();
    }
    @Bean("normalDog")
    public Animal dog() {
        return new Dog();
    }
    @Bean("mySuperDog")
    public Animal superDog() {
        //todo: add superpower
        return new Dog(true);
    }


}
