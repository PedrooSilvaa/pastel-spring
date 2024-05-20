package br.edu.senaisp.Pastel.model;

import br.edu.senaisp.Pastel.web.dto.PastelCreateDto;
import br.edu.senaisp.Pastel.web.dto.PastelResponseDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pastel")
public class Pastel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Column(name = "sabor", unique = true, nullable = true, length = 100)
    private String sabor;

    @NotBlank
    @Column(name = "acompanhamento", nullable = false, length = 100)
    private String acompanhamento = "Catchup e Mostarda";

    public Pastel(Integer id, String sabor, String acompanhamneto) {
        this.id = id;
        this.sabor = sabor;
        this.acompanhamento = acompanhamento;
    }

    public Pastel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getAcompanhamneto() {
        return acompanhamento;
    }

    public void setAcompanhamneto(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public static Pastel toPastel(PastelCreateDto pastelCreateDto){
        Pastel pastel = new Pastel();
        pastel.setSabor(pastelCreateDto.getSabor());
        return pastel;
    }

    public static PastelResponseDto toDto(Pastel pastel){
        PastelResponseDto dto = new PastelResponseDto();
        dto.setId(pastel.id);
        dto.setSabor(pastel.sabor);
        dto.setAcompanhamento(pastel.acompanhamento);
        return dto;
    }

    public static List<PastelResponseDto> toListDto(List<Pastel> pasteis){
        List<PastelResponseDto> dtos = new ArrayList<>();
        for (Pastel pastel : pasteis){
            dtos.add(pastel.toDto(pastel));
        }
        return dtos;
    }
}
