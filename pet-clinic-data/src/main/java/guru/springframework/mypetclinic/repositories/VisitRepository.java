package guru.springframework.mypetclinic.repositories;

import guru.springframework.mypetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
