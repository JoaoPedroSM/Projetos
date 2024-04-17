 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConcatenarArquivos {
    public static void main(String[] args) {

        criarArquivo("arquivo1.txt", "Conteúdo do arquivo 1");
        criarArquivo("arquivo2.txt", "Conteúdo do arquivo 2");

        concatenarArquivos("arquivo1.txt", "arquivo2.txt", "arquivo_concatenado.txt");

        System.out.println("Conteúdo dos arquivos concatenado com sucesso.");
    }

    private static void criarArquivo(String nomeArquivo, String conteudo) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) {
            escritor.write(conteudo);
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo " + nomeArquivo);
            e.printStackTrace();
        }
    }

    private static void concatenarArquivos(String arquivo1, String arquivo2, String arquivoSaida) {
        try (BufferedReader leitor1 = new BufferedReader(new FileReader(arquivo1));
                BufferedReader leitor2 = new BufferedReader(new FileReader(arquivo2));
                BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida))) {

            String linha;

            while ((linha = leitor1.readLine()) != null) {
                escritor.write(linha);
                escritor.newLine();
            }
            while ((linha = leitor2.readLine()) != null) {
                escritor.write(linha);
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao concatenar os arquivos.");
            e.printStackTrace();
        }
    }
}

