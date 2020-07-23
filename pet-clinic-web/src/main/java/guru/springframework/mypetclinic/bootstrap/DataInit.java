package guru.springframework.mypetclinic.bootstrap;

import guru.springframework.mypetclinic.model.Owner;
import guru.springframework.mypetclinic.model.Vet;
import guru.springframework.mypetclinic.services.OwnerService;
import guru.springframework.mypetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataInit(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("joe");
        owner.setLastName("cascioli");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("kristin");
        owner1.setLastName("peters");

        ownerService.save(owner1);

        System.out.println("Owners loaded...");
        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Lauren");
        vet.setLastName("Jacobson");
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Jess");
        vet1.setLastName("Biznes");
        vetService.save(vet1);

        System.out.println("Vets loaded...");

    }
}
