package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Flavour;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FlavourService {
    Optional<Flavour> getFlavourById(Integer id);

    Flavour addFlavour(Flavour flavour);

    List<Flavour> getAllFlavours();

    void deleteFlavour(Flavour flavour);
}
