import model.Bomba;
import model.Combustivel;
import model.Modelo;
import model.Veiculo;
import utils.ModeloUtils;
import utils.VeiculoUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class Posto {
    private static double precoGasolina = 2.9;
    private static double precoEtanol = 2.27;

    public static void main(String[] args) throws FileNotFoundException {
        List<Modelo> modelos = ModeloUtils.getModelosFromModelosCSV("modelos.csv");

        List<Veiculo> veiculos = VeiculoUtils.getVeiculosFromVeiculosCSV("veiculos.csv");

        Bomba bomba1 = new Bomba(Combustivel.GASOLINA, 10);
        Bomba bomba2 = new Bomba(Combustivel.ETANOL, 12);

        System.out.println("------------------------------\nResultado da simulacao");

        veiculos.forEach(veiculo -> {
            Modelo modelo = modelos.stream().filter(m -> m.getModelo().equals(veiculo.getModelo()))
                    .findFirst().orElseThrow(() -> new IllegalArgumentException("Dados do modelo do veiculo nao encontrado"));

            Combustivel combustivel = modelo.getCombustivelMaisRentavel(precoGasolina, precoEtanol);

            if (Combustivel.GASOLINA.equals(combustivel)) {
                bomba1.setTotalAbastecido(bomba1.getTotalAbastecido() + modelo.getCapacidadeTanque());


                Double tempoQuePassou = modelo.getCapacidadeTanque() / bomba1.getVelocidadeAbastecimento();
                bomba1.setTempo(bomba1.getTempo().plusMinutes(tempoQuePassou.longValue()));

                System.out.println(bomba1.getTempo().toString().substring(11) + " Veículo modelo " + veiculo.getModelo() +
                        ", placa " + veiculo.getPlaca() + " foi abastecido com " + modelo.getCapacidadeTanque() +
                        " litros de " + combustivel);
            } else {
                bomba2.setTotalAbastecido(bomba2.getTotalAbastecido() + modelo.getCapacidadeTanque());

                Double tempoQuePassou = modelo.getCapacidadeTanque() / bomba2.getVelocidadeAbastecimento();
                bomba2.setTempo(bomba2.getTempo().plusMinutes(tempoQuePassou.longValue()));

                System.out.println(bomba2.getTempo().toString().substring(11) + " Veículo modelo " + veiculo.getModelo() +
                        ", placa " + veiculo.getPlaca() + " foi abastecido com " + modelo.getCapacidadeTanque() +
                        " litros de " + combustivel);
            }
        });

        System.out.println("------------------------------\nResumo da simulacao");

        System.out.println("Total abastecido na bomba 1 (" + bomba1.getCombustivel() + "): "
                + bomba1.getTotalAbastecido() + " litros");
        System.out.println("Total abastecido na bomba 2 (" + bomba2.getCombustivel() + "): "
                + bomba2.getTotalAbastecido() + " litros");
        System.out.println("Total geral abastecido de GASOLINA: " + bomba1.getTotalAbastecido() + " litros");
        System.out.println("Total geral abastecido de ETANOL: " + bomba2.getTotalAbastecido() + " litros");
    }
}
