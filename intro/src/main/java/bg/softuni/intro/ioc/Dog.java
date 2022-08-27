package bg.softuni.intro.ioc;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PostConstruct;

public class Dog implements Animal, BeanNameAware, DisposableBean {

    private boolean superDog;

    public Dog() {
        this(false);
    }

    public Dog(boolean superDog) {
        this.superDog = superDog;
    }

    @Override
    public void makeNoise() {
        if (superDog) {
            System.out.println("Super Bark Super Bark");
        } else {
            System.out.println("Bark Bark");
        }
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("The dog is ready to bark");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("The name of this dog is: " + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("The dog is about to die");
    }
}
