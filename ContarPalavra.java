import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarPalavra {
    public static void main(String[] args) {
        String arquivoEntrada = "meuarquivo.txt";
        String palavraAlvo = "Java";
        int contador = 0;

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                contador += contarPalavraNaLinha(linha, palavraAlvo);
            }

            System.out.println("A palavra '" + palavraAlvo + "' aparece " + contador + " vezes.");

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }

    private static int contarPalavraNaLinha(String linha, String palavra) {
        String[] palavras = linha.split("\\s+");
        int contador = 0;
        for (String p : palavras) {
            if (p.equalsIgnoreCase(palavra)) {
                contador++;
            }
        }
        return contador;
    }
}

