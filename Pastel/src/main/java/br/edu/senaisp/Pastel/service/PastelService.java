package br.edu.senaisp.Pastel.service;


import br.edu.senaisp.Pastel.exception.DataInvalidException;
import br.edu.senaisp.Pastel.exception.PastelNotFoundException;
import br.edu.senaisp.Pastel.exception.PastelUniqueViolationException;
import br.edu.senaisp.Pastel.model.Pastel;
import br.edu.senaisp.Pastel.repository.IPastelRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PastelService {

    private final IPastelRepository pastelRepository;

    public PastelService(IPastelRepository pastelRepository) {
        this.pastelRepository = pastelRepository;
    }

    @Transactional
    public Pastel salvar(Pastel pastel){
        try {
        return pastelRepository.save(pastel);
        }catch (DataIntegrityViolationException ex){
            throw new PastelUniqueViolationException(String.format("Pastel do sabor %s já registrado", pastel.getSabor()));
        }
    }

    @Transactional(readOnly = true)
    public List<Pastel> listar(){
        return pastelRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Pastel buscarPorId(int id){
        return pastelRepository.findById(id).orElseThrow(
                () -> new PastelNotFoundException(String.format("Pastel id = %s não encontrado", id))
        );
    }

    @Transactional
    public Pastel altera(int id, String sabor, String confirmSabor, String novoSabor){

        if(!sabor.equals(confirmSabor)){
            throw new DataInvalidException("Sabor não confere");
        }

        Pastel pastel1 = buscarPorId(id);

        pastel1.setSabor(novoSabor);
        return pastel1;
    }

    public void delete(int id) {
        pastelRepository.deleteById(id);
    }
}
