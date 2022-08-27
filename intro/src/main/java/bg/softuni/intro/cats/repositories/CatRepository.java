package bg.softuni.intro.cats.repositories;

import bg.softuni.intro.cats.models.entities.CatEntity;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaAttributeConverter<CatEntity, Long> {
}
