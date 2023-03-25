package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bomba {
    private Combustivel combustivel;
    private double totalAbastecido;
    private LocalDateTime tempo;
    private double velocidadeAbastecimento;

    public Bomba(Combustivel combustivel, double velocidadeAbastecimento) {
        this.combustivel = combustivel;
        this.totalAbastecido = 0L;
        this.tempo = LocalDate.now().atStartOfDay();
        this.velocidadeAbastecimento = velocidadeAbastecimento;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public double getTotalAbastecido() {
        return totalAbastecido;
    }

    public void setTotalAbastecido(double totalAbastecido) {
        this.totalAbastecido = totalAbastecido;
    }

    public LocalDateTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }

    public double getVelocidadeAbastecimento() {
        return velocidadeAbastecimento;
    }

    public void setVelocidadeAbastecimento(double velocidadeAbastecimento) {
        this.velocidadeAbastecimento = velocidadeAbastecimento;
    }
}
