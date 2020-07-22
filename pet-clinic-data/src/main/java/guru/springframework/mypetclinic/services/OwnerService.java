package guru.springframework.mypetclinic.services;

import guru.springframework.mypetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
