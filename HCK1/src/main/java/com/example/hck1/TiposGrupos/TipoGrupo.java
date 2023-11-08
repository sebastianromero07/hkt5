package com.example.hck1.TiposGrupos;

import java.util.List;

import com.example.hck1.Grupo.Group;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class TipoGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    @JsonIgnore
    private List<Group> grupos;

    public TipoGrupo(){}
    public TipoGrupo(Long id, String name){
        this.id=id;
        this.name=name;
    }

    public Long getId(){return id;}
    public String getName(){return name;}
    public List<Group> getGrupos(){return grupos;}


    public void setId(Long id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setGroups(List<Group> grupos) {
        this.grupos = grupos;
    }

}