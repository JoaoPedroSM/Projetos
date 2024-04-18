package br.edu.joao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class meuarquivo_python {
    public static void main(String[] args) {
        String arquivoEntrada = "meuarquivo.txt";
        String arquivoSaida = "meuarquivo_python.txt";
        String palavraOriginal = "Java";
        String palavraSubstituta = "Python";

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
                BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida))) {

            String linha;
            while ((linha = leitor.readLine()) != null) {
                escritor.write(linha.replaceAll(palavraOriginal, palavraSubstituta) + "\n");
            }

            System.out.println("Substituição concluída.");

        } catch (IOException e) {
            System.out.println("Erro ao manipular arquivos.");
            e.printStackTrace();
        }
    }
}
