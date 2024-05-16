package com.example.soapproject.controllers;
import com.example.soapproject.models.Plat;
import com.example.soapproject.service.PlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plats")
public class RestControllerPlat {
    @Autowired
    private PlatService platService;

    @GetMapping
    public List<Plat> getAllPlats() {
        return platService.getAllPlats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plat> getPlatById(@PathVariable Long id) {
        Plat plat = platService.getPlatById(id);
        if (plat != null) {
            return ResponseEntity.ok(plat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Plat createPlat(@RequestBody Plat plat) {
        return platService.createPlat(plat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plat> updatePlat(@RequestBody Plat plat, @PathVariable Long id) {
        Plat existingPlat = platService.getPlatById(id);
        if (existingPlat != null) {
            plat.setId(id); // Ensure the correct item is updated
            return ResponseEntity.ok(platService.updatePlat(plat));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlat(@PathVariable Long id) {
        if (platService.getPlatById(id) != null) {
            platService.deletePlat(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}