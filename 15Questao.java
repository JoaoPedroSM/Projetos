import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiarArquivo {
    public static void main(String[] args) {
        String arquivoOrigem = "arquivo_grande.bin";
        String arquivoDestino = "copia_arquivo_grande.bin";

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(arquivoOrigem));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(arquivoDestino))) {

            byte[] buffer = new byte[8192]; // Buffer de 8KB (pode ajustar o tamanho conforme necessário)
            int bytesLidos;
            while ((bytesLidos = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesLidos);
            }

            System.out.println("Arquivo copiado com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao copiar o arquivo.");
            e.printStackTrace();
        }
    }
}

