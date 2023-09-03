package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonRepository personRepository;
    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Person with id " + id + " not found"));
    }
    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }
    @Override
    public List<Person> getAllPeople() {
        List<Person> peopleList = new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            peopleList.add(person);
        }
        return peopleList;
    }
    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }
}