package guru.springframework.mypetclinic.bootstrap;

import guru.springframework.mypetclinic.model.Owner;
import guru.springframework.mypetclinic.model.Pet;
import guru.springframework.mypetclinic.model.PetType;
import guru.springframework.mypetclinic.model.Vet;
import guru.springframework.mypetclinic.services.OwnerService;
import guru.springframework.mypetclinic.services.PetService;
import guru.springframework.mypetclinic.services.PetTypeService;
import guru.springframework.mypetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInit implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public DataInit(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Pet Types loaded...");

        Owner joe = new Owner();
        joe.setFirstName("Joe");
        joe.setLastName("Cascioli");
        joe.setAddress("69 Brickhouse rd");
        joe.setCity("Shesa");
        joe.setTelephone("5555551234");

        Pet joesPet = new Pet();
        joesPet.setName("Finn");
        joesPet.setPetType(savedDogType);
        joesPet.setOwner(joe);
        joesPet.setBirthday(LocalDate.now());
        joe.getPets().add(joesPet);
        ownerService.save(joe);


        Owner kristin = new Owner();
        kristin.setFirstName("Kristin");
        kristin.setLastName("Peters");
        kristin.setAddress("154 Loopy lane");
        kristin.setCity("Terpderp");
        kristin.setTelephone("5551231234");

        Pet kristinsPet = new Pet();
        kristinsPet.setName("Wolfy");
        kristinsPet.setPetType(savedCatType);
        kristinsPet.setBirthday(LocalDate.now());
        kristinsPet.setOwner(kristin);
        kristin.getPets().add(kristinsPet);
        ownerService.save(kristin);

        System.out.println("Owners loaded...");

        Vet vet = new Vet();
        vet.setFirstName("Lauren");
        vet.setLastName("Jacobson");
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jess");
        vet1.setLastName("Biznes");
        vetService.save(vet1);

        System.out.println("Vets loaded...");

    }
}
