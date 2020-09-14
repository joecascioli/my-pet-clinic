package guru.springframework.mypetclinic.controllers;

import guru.springframework.mypetclinic.model.Owner;
import guru.springframework.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping({"/index", "/index.html", "/home"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @GetMapping({"/find"})
    public String findOwnersPage(Model model){
        model.addAttribute("owner", Owner.builder().build());

        return "owners/findOwners";
    }

    @GetMapping({""})
    public String findOwner(Owner owner, BindingResult result, Map<String, Object> model){
        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastName(owner.getLastName());
        if(results.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }
        else if(results.size() == 1){
            return "redirect:/owners/"+results.get(0).getId();
        }
        else {
            model.put("owners", results);
            return "/owners/ownersList";
        }
    }

    @GetMapping({"/{ownerId}"})
    public String displayOwner(@PathVariable String ownerId, Model model){
        Owner owner = ownerService.findById(new Long(ownerId));
        model.addAttribute("owner", owner);
        return "owners/ownerDetails";
    }
}
