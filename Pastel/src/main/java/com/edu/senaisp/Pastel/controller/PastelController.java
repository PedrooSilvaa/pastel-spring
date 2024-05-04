package com.edu.senaisp.Pastel.controller;

import com.edu.senaisp.Pastel.model.Pastel;
import com.edu.senaisp.Pastel.repository.PastelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pastel")
public class PastelController {

    @Autowired
    PastelRepository repository;

    @GetMapping
    public List<Pastel> listAll(){
        return repository.list();
    }

    @GetMapping("/{id}")
    public Pastel listById(@PathVariable int id){
        return repository.findById(id);
    }

    @PostMapping
    public List<Pastel> create(@RequestBody Pastel pastel){
        return repository.insert(pastel);
    }

    @PutMapping("/{id}")
    public Pastel updateSabor(@RequestBody Pastel pastel, @PathVariable int id){
        return repository.update(pastel, id);
    }

    @DeleteMapping("/{id}")
    public void deleteSabor(@PathVariable int id){
        repository.delete(id);
    }

}
