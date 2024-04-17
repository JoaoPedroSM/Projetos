import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerProdutosCSV {
    public static void main(String[] args) {
        String arquivoCSV = "produtos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] cabecalho = reader.readNext();
            List<Produto> produtos = new ArrayList<>();

            String[] linha;
    
            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];
                double preco = Double.parseDouble(linha[1]);
                int quantidade = Integer.parseInt(linha[2]);
                produtos.add(new Produto(nome, preco, quantidade));
            }

        
            System.out.println("Detalhes dos produtos:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV.");
            e.printStackTrace();
        }
    }
}

class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}

