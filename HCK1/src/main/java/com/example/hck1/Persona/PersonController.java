package com.example.hck1.Persona;

import com.example.hck1.Grupo.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        List<Person> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping("groups/{id}")
    public ResponseEntity<Set<Group>> getGroupsForPerson(@PathVariable Long id) {
        Set<Group> groups = personService.getGroupsForPerson(id);
        return ResponseEntity.ok(groups);
    }

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        personService.save(person);
        return ResponseEntity.status(201).body("New person created");
    }
}


