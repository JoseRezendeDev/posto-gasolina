package dto;

import com.opencsv.bean.CsvBindByName;

public class ModeloCSV {
    @CsvBindByName(column = "Modelo")
    private String modelo;
    @CsvBindByName(column = "Consumo Etanol (Km/L)")
    private String consumoEtanol;
    @CsvBindByName(column = "Consumo Gasolina (Km/L)")
    private String consumoGasolina;
    @CsvBindByName(column = "Capacidade Tanque (L)")
    private String capacidadeTanque;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getConsumoEtanol() {
        return consumoEtanol;
    }

    public void setConsumoEtanol(String consumoEtanol) {
        this.consumoEtanol = consumoEtanol;
    }

    public String getConsumoGasolina() {
        return consumoGasolina;
    }

    public void setConsumoGasolina(String consumoGasolina) {
        this.consumoGasolina = consumoGasolina;
    }

    public String getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(String capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }
}
