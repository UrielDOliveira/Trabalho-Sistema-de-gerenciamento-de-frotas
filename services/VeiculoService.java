package services;

import entities.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public Veiculo buscarVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public void listarVeiculos() {
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }
}
