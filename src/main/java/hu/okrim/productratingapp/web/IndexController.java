package hu.okrim.productratingapp.web;

import hu.okrim.productratingapp.entity.Flavour;
import hu.okrim.productratingapp.entity.Rating;
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
    @GetMapping("")
    public String load(Model model) {
        List<Rating> ratings = ratingService.getThreeLatestRatings();
        model.addAttribute("ratings", ratings);
        return "index";
    }
    @GetMapping("/get-latest-reviews")
    public String loadLatestReviews(Model model){
        List<Rating> ratings = ratingService.getThreeLatestRatings();
        model.addAttribute("ratings", ratings);
        return "index";
    }
}
