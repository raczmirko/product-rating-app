package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Flavour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlavourService {
    Flavour getFlavourById(Integer id);

    void addFlavour(Flavour flavour);

    List<Flavour> getAllFlavours();

    void deleteFlavour(Flavour flavour);

    Page<Flavour> findAllByName(String name, Pageable request);
}
