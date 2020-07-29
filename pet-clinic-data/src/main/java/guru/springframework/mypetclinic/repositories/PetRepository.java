package guru.springframework.mypetclinic.repositories;

import guru.springframework.mypetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
