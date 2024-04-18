package edu.br.uniaeso;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Linha {
    public static void main(String[] args) throws Exception {
        LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(new FileInputStream("C:meuarquivo.txt")));
        String nextLine = null;
    
        try {
            while ((nextLine = lineCounter.readLine()) != null) {
                if (nextLine == null)
                    break;
                System.out.println(nextLine);
            }
            System.out.println("O total de linhas são: " + lineCounter.getLineNumber());
        } catch (Exception done) {
            done.printStackTrace();
        }
    }
}
