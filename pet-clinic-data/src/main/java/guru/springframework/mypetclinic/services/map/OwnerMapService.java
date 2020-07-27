package guru.springframework.mypetclinic.services.map;

import guru.springframework.mypetclinic.model.Owner;
import guru.springframework.mypetclinic.model.Pet;
import guru.springframework.mypetclinic.services.OwnerService;
import guru.springframework.mypetclinic.services.PetService;
import guru.springframework.mypetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService{

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {

        if(owner != null){
            owner.getPets().forEach( pet -> {
                if(pet.getPetType() != null){
                    if( pet.getPetType().getId() == null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else{
                    throw new RuntimeException("Pet Type is required");
                }
                if(pet.getId() == null){
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }

        return super.save(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }


}
