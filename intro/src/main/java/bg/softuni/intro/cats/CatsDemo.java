package bg.softuni.intro.cats;

import bg.softuni.intro.cats.models.dtos.CreateOwnerDto;
import bg.softuni.intro.cats.services.OwnerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CatsDemo implements CommandLineRunner {

    private OwnerService ownerService;

    public CatsDemo(OwnerService ownerService) {

        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {

        CreateOwnerDto ownerDto = new CreateOwnerDto();
        ownerService.createOwner(new CreateOwnerDto()
                .setOwnerNameDto("Pesho")
                .setCatNames(List.of("Jaccky, Tommy, Cat")));
    }
}
