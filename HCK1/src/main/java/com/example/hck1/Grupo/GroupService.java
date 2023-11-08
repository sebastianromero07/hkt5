package com.example.hck1.Grupo;

import com.example.hck1.Persona.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Long id) {
        Optional<Group> grupo = groupRepository.findById(id);
        return grupo.orElse(null);
    }

    public Set<Person> getPersonsForGroup(Long groupId) {
        Optional<Group> grupo = groupRepository.findById(groupId);
        return grupo.map(Group::getPersons).orElse(Collections.emptySet());
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }
     public boolean deleteGroup(Long id){
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if(optionalGroup.isPresent()){
            groupRepository.deleteById(id);
            return true;
        }
        return false;
     }
}




