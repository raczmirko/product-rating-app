package hu.okrim.productratingapp.web;

import hu.okrim.productratingapp.entity.Flavour;
import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.entity.Product;
import hu.okrim.productratingapp.entity.Rating;
import hu.okrim.productratingapp.service.PersonService;
import hu.okrim.productratingapp.service.ProductService;
import hu.okrim.productratingapp.service.ProductServiceImpl;
import hu.okrim.productratingapp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    RatingService ratingService;
    @Autowired
    PersonService personService;
    @Autowired
    ProductService productService;
    @GetMapping("")
    public String load(Model model) {
        List<Rating> ratings = ratingService.getThreeLatestRatings();
        model.addAttribute("ratings", ratings);
        Person person = personService.getPersonWithMostRatings();
        model.addAttribute("personWithMostRatings", person);
        Integer ratingCount  = personService.getRatingCountOfPersonWithMostRatings();
        model.addAttribute("ratingCount", ratingCount);
        List<Product> productsWithMostRatings = productService.findTop3ProductsWithMostRatings();
        model.addAttribute("productsWithMostRatings", productsWithMostRatings);
        List<Double> averagesForProductsWithMostRatings = productService.getRatingAverageForTop3ProductsWithBestRatings();
        model.addAttribute("averagesForProductsWithMostRatings", averagesForProductsWithMostRatings);
        return "index";
    }
    @GetMapping("/get-latest-reviews")
    public String loadLatestReviews(Model model){
        List<Rating> ratings = ratingService.getThreeLatestRatings();
        model.addAttribute("ratings", ratings);
        return "index";
    }
}
