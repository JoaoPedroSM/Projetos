import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GerenciadorProdutos {
    private static final String FILENAME = "produtos.csv";

    public static void main(String[] args) {
        excluirProduto();
    }

    private static void excluirProduto() {
        try {
            File inputFile = new File(FILENAME);
            File tempFile = new File("temp.csv");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do produto a ser excluído:");
            String nomeExcluir = scanner.nextLine();

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean encontrado = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nomeProduto = parts[0].trim();

                if (!nomeProduto.equalsIgnoreCase(nomeExcluir)) {
                    writer.write(line + System.lineSeparator());
                } else {
                    encontrado = true;
                }
            }

            reader.close();
            writer.close();

            if (!encontrado) {
                System.out.println("Produto não encontrado!");
            } else {
                inputFile.delete();
                tempFile.renameTo(inputFile);
                System.out.println("Produto excluído com sucesso!");
            }

        } catch (IOException e) {
            System.err.println("Erro ao excluir produto: " + e.getMessage());
        }
    }
}

