package utils;

import model.Veiculo;

import java.io.FileNotFoundException;
import java.util.List;

public class VeiculoUtils {
    public static List<Veiculo> getVeiculosFromVeiculosCSV(String nomeArquivo) throws FileNotFoundException {
        LeitorCSV leitorCSV = new LeitorCSV();

        return leitorCSV.lerCSV(new Veiculo(), nomeArquivo);
    }
}
