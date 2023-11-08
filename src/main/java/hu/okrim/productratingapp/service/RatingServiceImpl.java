package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.entity.Product;
import hu.okrim.productratingapp.entity.Rating;
import hu.okrim.productratingapp.entity.RatingId;
import hu.okrim.productratingapp.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    RatingRepository ratingRepository;
    @Override
    public Rating getRatingById(RatingId id) {
        return ratingRepository.findById(id).orElse(null);
    }

    @Override
    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        List<Rating> ratingList = new ArrayList<>();
        ratingList.addAll(ratingRepository.findAllByOrderByDateDesc());
        return ratingList;
    }

    @Override
    public void deleteRating(Rating rating) {
        ratingRepository.delete(rating);
    }

    @Override
    public List<Rating> getThreeLatestRatings() {
        return new ArrayList<>(ratingRepository.findThreeLatestRatings());
    }

    @Override
    public Rating getRatingById(Person person, Product product) {
        return ratingRepository.findById(person, product);
    }
}
