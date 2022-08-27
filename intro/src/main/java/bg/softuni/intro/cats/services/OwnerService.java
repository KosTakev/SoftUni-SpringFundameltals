package bg.softuni.intro.cats.services;

import bg.softuni.intro.cats.models.dtos.CreateOwnerDto;

public interface OwnerService {

    void createOwner(CreateOwnerDto createOwnerDto);
}
