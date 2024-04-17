import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;
    private double salario;

    public Funcionario(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Salário: " + salario;
    }
}

public class GerenciadorFuncionarios {
    private static final String FILENAME = "funcionarios.dat";

    public static void main(String[] args) {
        adicionarFuncionario();
    }

    private static void adicionarFuncionario() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME, true))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do funcionário:");
            String nome = scanner.nextLine();
            System.out.println("Digite a idade do funcionário:");
            int idade = scanner.nextInt();
            System.out.println("Digite o salário do funcionário:");
            double salario = scanner.nextDouble();
            Funcionario funcionario = new Funcionario(nome, idade, salario);
            outputStream.writeObject(funcionario);
            System.out.println("Funcionário adicionado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao adicionar funcionário: " + e.getMessage());
        }
    }
}

