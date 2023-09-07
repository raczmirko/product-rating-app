package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    Rating getRatingById(RatingId id);

    void addRating(Rating rating);

    List<Rating> getAllRatings();

    void deleteRating(Rating rating);

    List<Rating> getThreeLatestRatings();

    Rating getRatingById(Person person, Product product);

}