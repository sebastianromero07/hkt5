package com.example.hck1.TiposGrupos;
import com.example.hck1.Grupo.Group;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "Tiposgrupo")
public class Tiposgrupos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy= "tiposgrupos")
    private Set<Group> grupo = new HashSet<>();
    public Tiposgrupos() {
    }
    public Tiposgrupos(Long id, String name, Group grupo) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
