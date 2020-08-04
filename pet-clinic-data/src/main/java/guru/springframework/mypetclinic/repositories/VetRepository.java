package guru.springframework.mypetclinic.repositories;

import guru.springframework.mypetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
