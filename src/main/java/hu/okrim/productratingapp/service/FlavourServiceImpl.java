package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Flavour;
import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.repository.FlavourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlavourServiceImpl implements FlavourService{
    @Autowired
    FlavourRepository flavourRepository;

    @Override
    public Flavour getFlavourById(String id) {
        return null;
    }

    @Override
    public Flavour addFlavour(Flavour flavour) {
        return flavourRepository.save(flavour);
    }

    @Override
    public List<Flavour> getAllFlavours() {
        List<Flavour> flavourList = new ArrayList<>();
        for (Flavour flavour: flavourRepository.findAll()) {
            flavourList.add(flavour);
        }
        return flavourList;
    }

    @Override
    public void deleteFlavour(Flavour flavour) {
        flavourRepository.delete(flavour);
    }
}
