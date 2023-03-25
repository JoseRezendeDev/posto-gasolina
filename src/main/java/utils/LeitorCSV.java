package utils;

import com.opencsv.bean.CsvToBeanBuilder;
import model.Veiculo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class LeitorCSV {

    public <T> List<T> lerCSV(T clazz, String nomeArquivo) throws FileNotFoundException {
        try {
            List<T> objects = new CsvToBeanBuilder(new FileReader(nomeArquivo))
                    .withType(clazz.getClass())
                    .withSeparator(';')
                    .build()
                    .parse();

            return objects;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado");
            throw e;
        }
    }
}
