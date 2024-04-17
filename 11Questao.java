package br.edu.uniaeso;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class App {

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
    }
}
