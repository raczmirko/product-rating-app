package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface PersonService {
    Person getPersonById(String id);

    Person addPerson(Person person);

    List<Person> getAllPeople();

    void deletePerson(Person person);
}
