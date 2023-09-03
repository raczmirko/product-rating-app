package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Flavour;
import hu.okrim.productratingapp.entity.Rating;
import hu.okrim.productratingapp.entity.RatingId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    Rating getRatingById(RatingId id);

    void addRating(Rating rating);

    List<Rating> getAllRatings();

    void deleteRating(Rating rating);

}