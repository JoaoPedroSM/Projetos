
import java.io.FileInputStream;
import java.io.IOException;

public class LerPrimeirosBytes {
    public static void main(String[] args) {
        String nomeArquivo = "arquivo.bin";

        try (FileInputStream arquivo = new FileInputStream(nomeArquivo)) {
            byte[] buffer = new byte[100];
            int bytesLidos = arquivo.read(buffer);
            
            if (bytesLidos != -1) {
                for (int i = 0; i < bytesLidos; i++) {
                    System.out.printf("%02X ", buffer[i]);
                }
                System.out.println(); 
            } else {
                System.out.println("O arquivo está vazio.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
}
