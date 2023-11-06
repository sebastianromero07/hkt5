package com.example.hck1.Grupo;

import com.example.hck1.Persona.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping
    public ResponseEntity<List<Group>> getAll() {
        List<Group> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        Group grupo = groupService.getGroupById(id);
        return ResponseEntity.ok(grupo);
    }

    @GetMapping("persons/{id}")
    public ResponseEntity<Set<Person>> getPersonsForGroup(@PathVariable Long id) {
        Set<Person> persons = groupService.getPersonsForGroup(id);
        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public ResponseEntity<String> createGroup(@RequestBody Group grupo) {
        groupService.createGroup(grupo);
        return ResponseEntity.status(201).body("New gruop created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long id) {
        boolean deleted = groupService.deleteGroup(id);
        if (deleted) {
            return ResponseEntity.status(200).body("Deleted");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }
}



