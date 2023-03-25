package model;

import com.opencsv.bean.CsvBindByName;


public class Veiculo {
    @CsvBindByName(column = "Modelo")
    private String modelo;
    @CsvBindByName(column = "Placa")
    private String placa;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
