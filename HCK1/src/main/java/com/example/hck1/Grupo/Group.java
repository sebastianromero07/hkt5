package com.example.hck1.Grupo;

import com.example.hck1.Persona.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.example.hck1.TiposGrupos.Tiposgrupos;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Grupo")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "groups")
    @JsonIgnore
    private Set<Person> persons = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "tiposgrupos")
    private Tiposgrupos tiposgrupos;

    public Group(){}
    public Group(Long id, String name, Set<Person> persons) {
        this.id = id;
        this.name = name;
        this.persons = persons;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void set(String name){
        this.name = name;
    }
    public Set<Person> getPersons() {
        return persons;
    }
    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Tiposgrupos getTiposGrupos() {
        return tiposgrupos;
    }

    public void SetTiposGrupos(Tiposgrupos tiposgrupos){
        this.tiposgrupos = tiposgrupos;
    }

}