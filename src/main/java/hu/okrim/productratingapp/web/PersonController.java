package hu.okrim.productratingapp.web;

import hu.okrim.productratingapp.entity.Constants;
import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PersonController {
    @Autowired
    PersonService personService;
    @GetMapping("")
    public String listPeople(Model model) {
        List<Person> people = personService.getAllPeople();
        model.addAttribute("people", people);
        return "people";
    }
    @PostMapping("/add-person")
    public String addPerson(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
        Person person = new Person();
        person.setName(name);
        personService.addPerson(person);
        String status = Constants.SUCCESS_STATUS;
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/people";
    }
    @PostMapping("/delete-person")
    public String deletePerson(@RequestParam("person") Person person, RedirectAttributes redirectAttributes){
        personService.deletePerson(person);
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/people";
    }
}