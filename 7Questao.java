
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenarLinhas {
    public static void main(String[] args) {
        String arquivoEntrada = "meuarquivo.txt";
        String arquivoSaida = "meuarquivo_ordenado.txt";
        List<String> linhas = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                linhas.add(linha);
            }
            Collections.sort(linhas);
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo.");
            e.printStackTrace();
            return;
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida))) {
            for (String linha : linhas) {
                escritor.write(linha);
                escritor.newLine();
            }
            System.out.println("Linhas ordenadas e salvas em '" + arquivoSaida + "'.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }
}
