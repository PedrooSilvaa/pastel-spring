package br.edu.senaisp.Pastel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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
    private String acompanhamento;

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
}
