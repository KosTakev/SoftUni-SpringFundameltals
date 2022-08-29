package bg.softuni.intro.cats.services.impls;

import bg.softuni.intro.cats.models.dtos.CreateOwnerDto;
import bg.softuni.intro.cats.models.entities.CatEntity;
import bg.softuni.intro.cats.models.entities.OwnerEntity;
import bg.softuni.intro.cats.repositories.OwnerRepository;
import bg.softuni.intro.cats.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void createOwner(CreateOwnerDto createOwnerDto) {

        OwnerEntity owner = new OwnerEntity().setOwnerName(createOwnerDto.getOwnerNameDto());

        createOwnerDto.getCatNames()
                .forEach(name -> {
                   CatEntity cat = new CatEntity().setCatName(name)
                            .setOwner(owner);
                    owner.addCat(cat);
                });

        ownerRepository.save(owner);
    }
}
