import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FiltrarFuncionariosCSV {
    public static void main(String[] args) {
        String arquivoCSV = "funcionarios.csv";

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            Scanner scanner = new Scanner(System.in);
            List<String[]> funcionarios = reader.readAll();

            System.out.println("Filtrar funcionários:");
            System.out.println("1. Por cargo");
            System.out.println("2. Por salário mínimo");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Digite o cargo desejado: ");
                    String cargoDesejado = scanner.nextLine();
                    filtrarPorCargo(funcionarios, cargoDesejado);
                    break;
                case 2:
                    System.out.print("Digite o salário mínimo desejado: ");
                    double salarioMinimo = Double.parseDouble(scanner.nextLine());
                    filtrarPorSalario(funcionarios, salarioMinimo);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV.");
            e.printStackTrace();
        }
    }

    private static void filtrarPorCargo(List<String[]> funcionarios, String cargo) {
        System.out.println("\nFuncionários com o cargo de " + cargo + ":");
        for (String[] funcionario : funcionarios) {
            if (funcionario[1].equalsIgnoreCase(cargo)) {
                System.out.println(
                        "Nome: " + funcionario[0] + ", Cargo: " + funcionario[1] + ", Salário: " + funcionario[2]);
            }
        }
    }

    private static void filtrarPorSalario(List<String[]> funcionarios, double salarioMinimo) {
        System.out.println("\nFuncionários com salário igual ou superior a " + salarioMinimo + ":");
        for (String[] funcionario : funcionarios) {
            double salario = Double.parseDouble(funcionario[2]);
            if (salario >= salarioMinimo) {
                System.out.println(
                        "Nome: " + funcionario[0] + ", Cargo: " + funcionario[1] + ", Salário: " + funcionario[2]);
            }
        }
    }
}

