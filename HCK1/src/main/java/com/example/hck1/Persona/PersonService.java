package com.example.hck1.Persona;
import com.example.hck1.Grupo.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {
    @Autowired
        PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }

    public Set<Group> getGroupsForPerson(Long personId) {
        Optional<Person> person = personRepository.findById(personId);
        return person.map(Person::getGroups).orElse(Collections.emptySet());
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }
}





