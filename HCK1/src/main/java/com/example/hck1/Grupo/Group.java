package com.example.hck1.Grupo;
import com.example.hck1.Persona.Person;
import com.example.hck1.TiposGrupos.TipoGrupo;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Grupo")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "person_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> persons = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "tipoGrupo_id")
    private TipoGrupo tipoGrupo;
    public Group(){}
    public Group(Long id, String name, Set<Person> persons, TipoGrupo tipoGrupo) {
        this.id = id;
        this.name = name;
        this.persons = persons;
        this.tipoGrupo = tipoGrupo;
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
    public void setName(String name){
        this.name = name;
    }
    public Set<Person> getPersons() {
        return persons;
    }
    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
    public TipoGrupo getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(TipoGrupo tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

}