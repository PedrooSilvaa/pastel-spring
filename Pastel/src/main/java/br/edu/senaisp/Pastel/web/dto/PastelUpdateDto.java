package br.edu.senaisp.Pastel.web.dto;

public class PastelUpdateDto {

    private String sabor;
    private String confirmSabor;
    private String novoSabor;

    public PastelUpdateDto() {
    }

    public PastelUpdateDto(String sabor, String confirmSabor, String novoSabor) {
        this.sabor = sabor;
        this.confirmSabor = confirmSabor;
        this.novoSabor = novoSabor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getConfirmSabor() {
        return confirmSabor;
    }

    public void setConfirmSabor(String confirmSabor) {
        this.confirmSabor = confirmSabor;
    }

    public String getNovoSabor() {
        return novoSabor;
    }

    public void setNovoSabor(String novoSabor) {
        this.novoSabor = novoSabor;
    }

    @Override
    public String toString() {
        return "PastelUpdateDto{" +
                "sabor='" + sabor + '\'' +
                ", confirmSabor='" + confirmSabor + '\'' +
                ", novoSabor='" + novoSabor + '\'' +
                '}';
    }
}
