package br.edu.senaisp.Pastel.service;


import br.edu.senaisp.Pastel.model.Pastel;
import br.edu.senaisp.Pastel.repository.IPastelRepository;
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
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Transactional(readOnly = true)
    public List<Pastel> listar(){
        return pastelRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Pastel buscarPorId(int id){
        return pastelRepository.findById(id).orElseThrow(
                    RuntimeException::new
        );
    }

    @Transactional
    public Pastel altera(int id, Pastel pastel){
        Pastel pastel1 = buscarPorId(id);
        pastel1.setSabor(pastel.getSabor());
        pastel1.setAcompanhamneto(pastel.getAcompanhamneto());
        return pastel1;
    }

    public void delete(int id) {
        pastelRepository.deleteById(id);
    }
}
