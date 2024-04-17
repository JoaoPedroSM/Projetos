import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscreverCSV {
    public static void main(String[] args) {
        String arquivoCSV = "funcionarios.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nAdicionar funcionário:");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                if (nome.isEmpty()) break; 
                System.out.print("Cargo: ");
                String cargo = scanner.nextLine();
                System.out.print("Salário: ");
                String salario = scanner.nextLine();

                writer.writeNext(new String[]{nome, cargo, salario});
            }

            System.out.println("Dados dos funcionários adicionados ao arquivo 'funcionarios.csv'.");

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV.");
            e.printStackTrace();
        }
    }
}

