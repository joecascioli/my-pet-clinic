package guru.springframework.mypetclinic.services.map;

import guru.springframework.mypetclinic.model.Specialty;
import guru.springframework.mypetclinic.model.Vet;
import guru.springframework.mypetclinic.services.SpecialtyService;
import guru.springframework.mypetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {

        if(vet !=null) {
            vet.getSpecialties().forEach( specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }else{
            throw new RuntimeException("Vet is null");
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
