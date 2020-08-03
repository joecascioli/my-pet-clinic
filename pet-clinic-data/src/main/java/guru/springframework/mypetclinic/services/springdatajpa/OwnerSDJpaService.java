package guru.springframework.mypetclinic.services.springdatajpa;

import guru.springframework.mypetclinic.model.Owner;
import guru.springframework.mypetclinic.repositories.OwnerRepository;
import guru.springframework.mypetclinic.repositories.PetRepository;
import guru.springframework.mypetclinic.repositories.PetTypeRepository;
import guru.springframework.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
