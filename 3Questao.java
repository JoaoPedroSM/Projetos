package edu.br.uniaeso;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class meuarquivo 
{
    public static void main( String[] args ){
    String meuarquivo = "meuarquivo.txt";
    try{
        FileWriter
        arquivoWriter = new
        FileWriter (meuarquivo);
        PrintWriter escrever = new PrintWriter(meuarquivo);
        escrever.println("Olá, mundo!");
        escrever.println("Isso é uma adição");
        escrever.close();
        arquivoWriter.close();
        System.out.println(("Arquivo criado com sucesso."));
    } catch (IOException e) {
        System.out.println(("Ocorreu um erro!!"));
        e.printStackTrace();
     }
    }
}
