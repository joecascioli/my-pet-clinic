package guru.springframework.mypetclinic.controllers;

import guru.springframework.mypetclinic.model.Owner;
import guru.springframework.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"", "/index", "/index.html", "/home"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping({"/find"})
    public String findOwners(){
        return "notimplemented";
    }

    @GetMapping({"/{ownerId}"})
    public String displayOwner(@PathVariable String ownerId, Model model){
        Owner owner = ownerService.findById(new Long(ownerId));
        model.addAttribute("owner", owner);
        return "owners/ownerDetails";
    }
}
