import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class LerCSV {
    public static void main(String[] args) {
        String arquivoCSV = "alunos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
           
            while ((linha = reader.readNext()) != null) {
                for (String valor : linha) {
                    System.out.print(valor + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV.");
            e.printStackTrace();
        }
    }
}

