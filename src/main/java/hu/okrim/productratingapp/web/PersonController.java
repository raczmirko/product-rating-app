package hu.okrim.productratingapp.web;

import hu.okrim.productratingapp.entity.Constants;
import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    @GetMapping("/add-person")
    public String showAddPersonForm(Model model) {
        model.addAttribute("person", new Person());
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
//    @GetMapping
//    public String getForm(Model model, @RequestParam(required = false) String id){
//        return "people";
//    }
}
