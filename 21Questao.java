import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class EscreverProdutosCSV {
    public static void main(String[] args) {
        String arquivoCSV = "produtos.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV, true))) {
            Scanner scanner = new Scanner(System.in);

            // Solicitar detalhes dos produtos e escrever no arquivo CSV
            while (true) {
                System.out.println("\nAdicionar produto:");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                if (nome.isEmpty()) break; // Se o nome estiver vazio, terminar o loop
                System.out.print("Preço: ");
                double preco = Double.parseDouble(scanner.nextLine());
                System.out.print("Quantidade: ");
                int quantidade = Integer.parseInt(scanner.nextLine());

                writer.writeNext(new String[]{nome, Double.toString(preco), Integer.toString(quantidade)});
            }

            System.out.println("Produtos adicionados ao arquivo 'produtos.csv'.");

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV.");
            e.printStackTrace();
        }
    }
}

