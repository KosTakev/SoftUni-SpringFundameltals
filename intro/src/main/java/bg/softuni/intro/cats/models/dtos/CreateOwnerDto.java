package bg.softuni.intro.cats.models.dtos;

import org.springframework.context.annotation.Bean;

import java.util.List;
public class CreateOwnerDto {

    private String ownerNameDto;
    private List<String> catNames;


    public String getOwnerNameDto() {
        return ownerNameDto;
    }

    public CreateOwnerDto setOwnerNameDto(String ownerNameDto) {
        this.ownerNameDto = ownerNameDto;
        return this;
    }

    public List<String> getCatNames() {
        return catNames;
    }

    public CreateOwnerDto setCatNames(List<String> catNames) {
        this.catNames = catNames;
        return this;
    }
}
