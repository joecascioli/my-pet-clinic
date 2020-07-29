package guru.springframework.mypetclinic.repositories;

import guru.springframework.mypetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
