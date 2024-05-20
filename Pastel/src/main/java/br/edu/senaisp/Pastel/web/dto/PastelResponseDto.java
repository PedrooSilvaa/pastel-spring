package br.edu.senaisp.Pastel.web.dto;

public class PastelResponseDto {

    private Integer id;
    private String sabor;
    private String acompanhamento;

    public PastelResponseDto() {
    }

    public PastelResponseDto(Integer id, String sabor, String acompanhamento) {
        this.id = id;
        this.sabor = sabor;
        this.acompanhamento = acompanhamento;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PastelResponseDto{" +
                "id=" + id +
                ", sabor='" + sabor + '\'' +
                ", acompanhamento='" + acompanhamento + '\'' +
                '}';
    }
}
