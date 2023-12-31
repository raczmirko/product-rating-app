package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Flavour;
import hu.okrim.productratingapp.repository.FlavourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlavourServiceImpl implements FlavourService{
    @Autowired
    FlavourRepository flavourRepository;

    public Flavour getFlavourById(Integer id) {
        return flavourRepository.findById(id).orElse(null);
    }

    @Override
    public void addFlavour(Flavour flavour) {
        flavourRepository.save(flavour);
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

    @Override
    public Page<Flavour> findAllByName(String name, Pageable request) {
        return flavourRepository.findAllByName(name, request);
    }
}
