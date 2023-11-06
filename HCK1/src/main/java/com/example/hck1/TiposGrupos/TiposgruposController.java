package com.example.hck1.TiposGrupos;

import com.example.hck1.Grupo.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tiposgrupos")
@CrossOrigin(origins = "*")
public class TiposgruposController {
    @Autowired
    TiposgruposService tiposgruposService;

    @GetMapping
    public ResponseEntity<List<Tiposgrupos>> getAll() {
        List<Tiposgrupos> tiposgrupos = tiposgruposService.getAllTiposgrupos();
        return ResponseEntity.ok(tiposgrupos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tiposgrupos> getTiposgruposById(@PathVariable Long id) {
        Tiposgrupos tiposgrupos = tiposgruposService.getTiposgruposById(id);
        return ResponseEntity.ok(tiposgrupos);
    }
    @PostMapping
    public ResponseEntity<String> createTiposgrupos(@RequestBody Tiposgrupos tiposgrupos) {
        tiposgruposService.save(tiposgrupos);
        return ResponseEntity.status(201).body("New tiposgrupos created");
    }
}