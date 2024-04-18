package br.edu.joao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoCSV {
    public static void main(String[] args) {
        String arquivoCSV = "dados.csv";

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
               
                String[] campos = linha.split(",");

                for (String campo : campos) {
                    System.out.print(campo + "\t");
                }
                System.out.println(); 
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV.");
            e.printStackTrace();
        }
    }
}
