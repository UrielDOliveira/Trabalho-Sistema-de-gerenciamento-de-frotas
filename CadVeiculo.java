import entities.Carro;
import entities.Moto;
import entities.Veiculo;
import services.VeiculoService;

import java.util.Scanner;

public class CadVeiculo {
    private static final VeiculoService veiculoService = new VeiculoService();
    private static final Scanner scanner = new Scanner(System.in);

    // MENU
    private static void exibirMenu() {
        System.out.println("\n"
            + "╔═══════════════════════════════════════════════╗\n"
            + "║                    MENU                       ║\n"
            + "╠═══════════════════════════════════════════════╣\n"
            + "║  1 - Cadastrar um Veículo                     ║\n"
            + "║  2 - Listar Veículos                          ║\n"
            + "║  3 - Buscar Veículo pela placa                ║\n"
            + "║  4 - Remover Veículo                          ║\n"
            + "║  0 - Sair                                     ║\n"
            + "╚═══════════════════════════════════════════════╝\n"
            + "Escolha uma opção: ");
    }

    // ADD VEICULO
    private static void adicionarVeiculo() {
        System.out.println("\n=== Adicionar Veículo ===");
        System.out.println("Escolha o tipo de veículo:");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a marca do veículo: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o ano do veículo: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        Veiculo novoVeiculo = null;
        switch (tipoVeiculo) {
            case 1:
                System.out.print("Digite o número de portas: ");
                int numeroPortas = scanner.nextInt();
                scanner.nextLine();
                novoVeiculo = new Carro(marca, modelo, ano, placa, numeroPortas);
                break;
            case 2:
                novoVeiculo = new Moto(marca, modelo, ano, placa);
                break;
            default:
                System.out.println("Tipo de veículo inválido.");
                return;
        }

        veiculoService.adicionarVeiculo(novoVeiculo);
        System.out.println("Veículo adicionado com sucesso!");
    }

    // LISTAR VEICULOS
    private static void listarVeiculos() {
        System.out.println("\n=== Listar Veículos ===");
        veiculoService.listarVeiculos();
    }

    // BUSCAR VEICULO
    private static void buscarVeiculo() {
        System.out.println("\n=== Buscar Veículo ===");
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = veiculoService.buscarVeiculo(placa);
        if (veiculo != null) {
            System.out.println("Veículo encontrado:\n" + veiculo);
        } else {
            System.out.println("Veículo com placa " + placa + " não foi encontrado.");
        }
    }

    // REMOVER VEICULO
    private static void removerVeiculo() {
        System.out.println("\n=== Remover Veículo ===");
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = veiculoService.buscarVeiculo(placa);
        if (veiculo != null) {
            veiculoService.removerVeiculo(veiculo);
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Veículo com placa " + placa + " não foi encontrado.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    buscarVeiculo();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
