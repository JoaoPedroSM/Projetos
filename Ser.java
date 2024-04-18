package br.edu.uniaeso;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ser {

    static class Pessoa implements Serializable {
        private String nome;
        private int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }
    }

    public static void main(String[] args) {
   
        Pessoa pessoa = new Pessoa("João", 30);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pessoa.dat"))) {
            out.writeObject(pessoa);
            System.out.println("Objeto Pessoa serializado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pessoa.dat"))) {
            Pessoa pessoaDeserializada = (Pessoa) in.readObject();
            System.out.println("Detalhes da pessoa deserializada:");
            System.out.println("Nome: " + pessoaDeserializada.getNome());
            System.out.println("Idade: " + pessoaDeserializada.getIdade());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
