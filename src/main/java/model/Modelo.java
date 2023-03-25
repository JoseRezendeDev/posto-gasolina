package model;

import com.opencsv.bean.CsvBindByName;


public class Modelo {
    @CsvBindByName(column = "Modelo")
    private String modelo;
    @CsvBindByName(column = "Consumo Etanol (Km/L)")
    private double consumoEtanol;
    @CsvBindByName(column = "Consumo Gasolina (Km/L)")
    private double consumoGasolina;
    @CsvBindByName(column = "Capacidade Tanque (L)")
    private double capacidadeTanque;

    public Combustivel getCombustivelMaisRentavel(double precoGasolina, double precoEtanol) {
        if (consumoEtanol == 0) {
            return Combustivel.GASOLINA;
        } else if (consumoGasolina == 0) {
            return Combustivel.ETANOL;
        }

        double valorTotalReaisGasolina = precoGasolina * capacidadeTanque;
        double valorTotalReaisEtanol = precoEtanol * capacidadeTanque;

        double distanciaGasolina = consumoGasolina * capacidadeTanque;
        double distanciaEtanol = consumoEtanol * capacidadeTanque;

        double razaoGasolina = valorTotalReaisGasolina/distanciaGasolina;
        double razaoEtanol = valorTotalReaisEtanol/distanciaEtanol;

        if (razaoGasolina < razaoEtanol) {
            return Combustivel.GASOLINA;
        } else {
            return Combustivel.ETANOL;
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getConsumoEtanol() {
        return consumoEtanol;
    }

    public void setConsumoEtanol(double consumoEtanol) {
        this.consumoEtanol = consumoEtanol;
    }

    public double getConsumoGasolina() {
        return consumoGasolina;
    }

    public void setConsumoGasolina(double consumoGasolina) {
        this.consumoGasolina = consumoGasolina;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }
}
