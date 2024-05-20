package br.edu.senaisp.Pastel.web.controler;

import br.edu.senaisp.Pastel.model.Pastel;
import br.edu.senaisp.Pastel.service.PastelService;
import br.edu.senaisp.Pastel.web.dto.PastelCreateDto;
import br.edu.senaisp.Pastel.web.dto.PastelResponseDto;
import br.edu.senaisp.Pastel.web.dto.PastelUpdateDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PastelResponseDto> salvarPastel(@RequestBody @Valid PastelCreateDto pastelCreateDto){
        Pastel pastel = pastelService.salvar(Pastel.toPastel(pastelCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(Pastel.toDto(pastel));
    }

    @GetMapping
    public ResponseEntity<List<PastelResponseDto>> listarPasteis(){
        List<Pastel> pasteis = pastelService.listar();
        return ResponseEntity.ok(Pastel.toListDto(pasteis));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PastelResponseDto> buscarId(@PathVariable int id){
        Pastel pastel = pastelService.buscarPorId(id);
        return ResponseEntity.ok(Pastel.toDto(pastel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PastelResponseDto> alterar(@PathVariable int id, @RequestBody @Valid PastelUpdateDto pastelDto){
        Pastel pastel = pastelService.altera(id, pastelDto.getSabor(), pastelDto.getConfirmSabor(), pastelDto.getNovoSabor());
        return ResponseEntity.ok(Pastel.toDto(pastel));
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable int id){
        pastelService.delete(id);
        return "Excluido";
    }

}
