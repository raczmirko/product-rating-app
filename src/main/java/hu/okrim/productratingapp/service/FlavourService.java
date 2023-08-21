package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Flavour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlavourService {
    Flavour getFlavourById(String id);

    Flavour addFlavour(Flavour flavour);

    List<Flavour> getAllFlavours();

    void deleteFlavour(Flavour flavour);
}
