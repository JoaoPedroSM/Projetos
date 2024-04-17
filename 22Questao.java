
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class AtualizarProdutosCSV {
    public static void main(String[] args) {
        String arquivoCSV = "produtos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV));
             CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV + ".temp"))) {

            Scanner scanner = new Scanner(System.in);
            List<String[]> linhas = reader.readAll();

            // Exibir produtos disponíveis para atualização
            System.out.println("Produtos disponíveis para atualização:");
            for (int i = 1; i < linhas.size(); i++) {
                String[] produto = linhas.get(i);
                System.out.println(i + ". " + produto[0]); 
            }

            System.out.print("\nDigite o número do produto que deseja atualizar: ");
            int numeroProduto = Integer.parseInt(scanner.nextLine()) - 1; 

            if (numeroProduto < 0 || numeroProduto >= linhas.size() - 1) {
                System.out.println("Número de produto inválido.");
                return;
            }

            String[] produtoSelecionado = linhas.get(numeroProduto + 1); 

            System.out.println("\nProduto selecionado: " + produtoSelecionado[0]); 
            System.out.print("Novo preço (ou deixe em branco para manter o mesmo): ");
            String novoPrecoStr = scanner.nextLine();
            double novoPreco = novoPrecoStr.isEmpty() ? Double.parseDouble(produtoSelecionado[1]) : Double.parseDouble(novoPrecoStr);
            System.out.print("Nova quantidade em estoque (ou deixe em branco para manter a mesma): ");
            String novaQuantidadeStr = scanner.nextLine();
            int novaQuantidade = novaQuantidadeStr.isEmpty() ? Integer.parseInt(produtoSelecionado[2]) : Integer.parseInt(novaQuantidadeStr);

        
            produtoSelecionado[1] = Double.toString(novoPreco);
            produtoSelecionado[2] = Integer.toString(novaQuantidade);

         
            writer.writeAll(linhas);

            System.out.println("Produto atualizado com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo CSV.");
            e.printStackTrace();
        }
    }
}

