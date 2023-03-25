package utils;

import dto.ModeloCSV;
import model.Modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ModeloUtils {
    public static double getValueAsDouble(String value) {
        if (value.isEmpty()) {
            return 0;
        }

        return Double.parseDouble(value.replace(",", "."));
    }

    public static List<Modelo> getModelosFromModelosCSV(String nomeArquivo) throws FileNotFoundException {
        LeitorCSV leitorCSV = new LeitorCSV();

        List<ModeloCSV> modelosCSV = leitorCSV.lerCSV(new ModeloCSV(), nomeArquivo);

        List<Modelo> modelos = new ArrayList<>();

        modelosCSV.forEach(modeloCSV -> {
            Modelo modelo = new Modelo();
            modelo.setModelo(modeloCSV.getModelo());
            modelo.setConsumoEtanol(getValueAsDouble(modeloCSV.getConsumoEtanol()));
            modelo.setConsumoGasolina(getValueAsDouble(modeloCSV.getConsumoGasolina()));
            modelo.setCapacidadeTanque(getValueAsDouble(modeloCSV.getCapacidadeTanque()));

            modelos.add(modelo);
        });

        return modelos;
    }
}
