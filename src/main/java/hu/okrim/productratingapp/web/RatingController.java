package hu.okrim.productratingapp.web;

import hu.okrim.productratingapp.entity.*;
import hu.okrim.productratingapp.repository.RatingRepository;
import hu.okrim.productratingapp.service.PersonService;
import hu.okrim.productratingapp.service.ProductService;
import hu.okrim.productratingapp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingService ratingService;
    @Autowired
    ProductService productService;
    @Autowired
    PersonService personService;
    @GetMapping("")
    public String listRatings(Model model) {
        List<Rating> ratings = ratingService.getAllRatings();
        model.addAttribute("ratings", ratings);
        // Add code to fetch and add brands and categories for dropdowns
        List<Product> products = productService.getAllProducts();
        List<Person> people = personService.getAllPeople();
        model.addAttribute("products", products);
        model.addAttribute("people", people);
        return "ratings";
    }
    @PostMapping("/add-rating")
    public String addRating(
            @RequestParam("person") Person person,
            @RequestParam("product") Product product,
            @RequestParam("date") Date date,
            @RequestParam("taste") Byte taste,
            @RequestParam("smell") Byte smell,
            @RequestParam("remark") String remark,
            RedirectAttributes redirectAttributes) {

        // Create a new Product instance and set its properties
        Rating rating = new Rating(person,product,date,taste,smell,remark);

        // Save the product using the ProductService
        ratingService.addRating(rating);

        String status = Constants.SUCCESS_STATUS;
        redirectAttributes.addFlashAttribute("status", status);

        return "redirect:/ratings";
    }

    @PostMapping("/delete-rating")
    public String deleteRating(@RequestParam("rating") Rating rating, RedirectAttributes redirectAttributes){
        ratingService.deleteRating(rating);
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/ratings";
    }


}
