package br.edu.senaisp.Pastel.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class PastelCreateDto {

    @NotBlank
    private String sabor;

    public PastelCreateDto() {
    }

    public PastelCreateDto(String sabor) {
        this.sabor = sabor;
    }

    public @NotBlank String getSabor() {
        return sabor;
    }

    public void setSabor(@NotBlank String sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "PastelCreateDto{" +
                "sabor='" + sabor + '\'' +
                '}';
    }
}
