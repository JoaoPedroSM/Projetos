
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AtualizarConta {
    public static void main(String[] args) {
        ContaBancaria conta = carregarConta("conta.dat");

        if (conta != null) {
   
            conta.depositar(100); 

            salvarConta(conta, "conta.dat");

            System.out.println("Conta atualizada e salva com sucesso.");
        } else {
            System.out.println("Erro ao carregar a conta.");
        }
    }

    private static ContaBancaria carregarConta(String nomeArquivo) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (ContaBancaria) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar a conta: " + e.getMessage());
            return null;
        }
    }

    private static void salvarConta(ContaBancaria conta, String nomeArquivo) {
        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            saida.writeObject(conta);
        } catch (IOException e) {
            System.out.println("Erro ao salvar a conta: " + e.getMessage());
        }
    }
}

