package bg.softuni.intro.cats.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<CatEntity> cats = new ArrayList<>();

    public Long getOwnerId() {
        return ownerId;
    }

    public OwnerEntity setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public OwnerEntity setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public List<CatEntity> getCats() {
        return cats;
    }

    public OwnerEntity setCats(List<CatEntity> cats) {
        this.cats = cats;
        return this;
    }

    public OwnerEntity addCat(CatEntity cat) {
        cats.add(cat);
        return this;
    }
}
