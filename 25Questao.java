import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class ExportarVendasCSV {
    public static void main(String[] args) {
        List<Venda> vendas = criarListaDeVendas();

        if (exportarParaCSV(vendas)) {
            System.out.println("Vendas exportadas para 'vendas.csv' com sucesso.");
        } else {
            System.out.println("Erro ao exportar as vendas para 'vendas.csv'.");
        }
    }

    private static List<Venda> criarListaDeVendas() {
        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda("2024-04-30", 100.0, "Produto A"));
        vendas.add(new Venda("2024-04-30", 150.0, "Produto B"));
        vendas.add(new Venda("2024-04-30", 200.0, "Produto C"));
        vendas.add(new Venda("2024-05-01", 120.0, "Produto A"));
        vendas.add(new Venda("2024-05-01", 180.0, "Produto B"));
        return vendas;
    }

    private static boolean exportarParaCSV(List<Venda> vendas) {
        String arquivoCSV = "vendas.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            writer.writeNext(new String[] { "Data", "Valor", "Produto" });
            for (Venda venda : vendas) {
                writer.writeNext(
                        new String[] { venda.getData(), Double.toString(venda.getValor()), venda.getProduto() });
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

class Venda {
    private String data;
    private double valor;
    private String produto;

    public Venda(String data, double valor, String produto) {
        this.data = data;
        this.valor = valor;
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getProduto() {
        return produto;
    }
}

