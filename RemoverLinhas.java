import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoverLinhas {
    public static void main(String[] args) {
        String arquivoEntrada = "meuarquivo.txt";
        String arquivoSaida = "meuarquivo_sem_excluir.txt";

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida))) {

            String linha;
            while ((linha = leitor.readLine()) != null) {
            
                if (!linha.contains("excluir")) {
                    escritor.write(linha);
                    escritor.newLine();
                }
            }

            System.out.println("Linhas removidas e salvas em '" + arquivoSaida + "'.");

        } catch (IOException e) {
            System.out.println("Erro ao manipular os arquivos.");
            e.printStackTrace();
        }
    }
}
