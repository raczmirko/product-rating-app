package hu.okrim.productratingapp.web;

import hu.okrim.productratingapp.entity.Constants;
import hu.okrim.productratingapp.entity.Flavour;
import hu.okrim.productratingapp.service.FlavourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/flavours")
public class FlavourController {
    @Autowired
    FlavourService flavourService;
    @GetMapping("")
    public String listFlavours(Model model) {
        List<Flavour> flavours = flavourService.getAllFlavours();
        model.addAttribute("flavours", flavours);
        return "flavours";
    }
    @PostMapping("/add-flavour")
    public String addFlavour(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
        Flavour flavour = new Flavour();
        flavour.setName(name);
        flavourService.addFlavour(flavour);
        String status = Constants.SUCCESS_STATUS;
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/flavours";
    }
    @PostMapping("/delete-flavour")
    public String deleteFlavour(@RequestParam("flavour") Flavour flavour, RedirectAttributes redirectAttributes){
        flavourService.deleteFlavour(flavour);
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/flavours";
    }
}
