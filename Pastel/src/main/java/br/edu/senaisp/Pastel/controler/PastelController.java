package br.edu.senaisp.Pastel.controler;

import br.edu.senaisp.Pastel.model.Pastel;
import br.edu.senaisp.Pastel.repository.IPastelRepository;
import br.edu.senaisp.Pastel.service.PastelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasteis")
public class PastelController {

    private final PastelService pastelService;

    public PastelController(PastelService pastelService) {
        this.pastelService = pastelService;
    }

    @PostMapping
    public Pastel salvarPastel(@RequestBody @Valid Pastel pastel){
        return pastelService.salvar(pastel);
    }

    @GetMapping
    public List<Pastel> listarPasteis(){
        return pastelService.listar();
    }

    @GetMapping("/{id}")
    public Pastel buscarId(@PathVariable int id){
        return pastelService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Pastel alterar(@PathVariable int id, @RequestBody @Valid Pastel pastel){
        return pastelService.altera(id, pastel);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable int id){
        pastelService.delete(id);
        return "Excluido";
    }

}
