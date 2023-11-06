package com.example.hck1.TiposGrupos;
import com.example.hck1.Grupo.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.hck1.TiposGrupos.Tiposgrupos;

@Service
public class TiposgruposService {
    @Autowired
    TiposgruposRepository tiposgruposRepository;

    public List<Tiposgrupos> getAllTiposgrupos() {
        return tiposgruposRepository.findAll();
    }

    public Tiposgrupos getTiposgruposById(Long id) {
        Optional<Tiposgrupos> tiposgroups = tiposgruposRepository.findById(id);
        return tiposgroups.orElse(null);
    }

    public Tiposgrupos save(Tiposgrupos tiposgroups) {
        return tiposgruposRepository.save(tiposgroups);
    }
}