package guru.springframework.mypetclinic.bootstrap;

import guru.springframework.mypetclinic.model.*;
import guru.springframework.mypetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInit implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    @Autowired
    public DataInit(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Pet Types loaded...");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiologySpecialty = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgerySpecialty = specialtyService.save(surgery);

        System.out.println("Vet Specialties loaded...");

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

        Visit dogVisit = new Visit();
        dogVisit.setPet(joesPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Sneezy doggy");

        visitService.save(dogVisit);

        Visit catVisit = new Visit();
        catVisit.setPet(kristinsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        System.out.println("Visit Loaded....");

        Vet lJacobson = new Vet();
        lJacobson.setFirstName("Lauren");
        lJacobson.setLastName("Jacobson");
        lJacobson.getSpecialties().add(savedRadiologySpecialty);
        vetService.save(lJacobson);

        Vet jBbizes = new Vet();
        jBbizes.setFirstName("Jess");
        jBbizes.setLastName("Biznes");
        jBbizes.getSpecialties().add(savedSurgerySpecialty);
        vetService.save(jBbizes);

        System.out.println("Vets loaded...");
    }
}
