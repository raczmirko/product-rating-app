package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PersonService {
    Person getPersonById(Integer id);

    Person addPerson(Person person);

    List<Person> getAllPeople();

    void deletePerson(Person person);
}
