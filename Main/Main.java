package Main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criação da lista de financiamentos

        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        financiamentos.add(new Apartamento(500000,12,20, 2, 6));
        financiamentos.add(new Apartamento(200000,40,22,1,3));

        financiamentos.add(new Casa (300000,60,20, 100,400));
        financiamentos.add(new Casa(600000,80,30, 200, 600));

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // pedir ao usuario os valores de apenas um financiamento

            System.out.println("Financiamento de terreno: ");

            double valorDoImovel = interfaceUsuario.CapturarValorDoImovel();
            System.out.println("O valor do imovel é: R$ " + valorDoImovel);

            int prazoDeFinanciamento = interfaceUsuario.CapturarValorDoPrazoDoFinanciamentoEmAnos();
            System.out.println("Prazo do financiamento em anos: " + prazoDeFinanciamento);

            double taxaJurosAnual = interfaceUsuario.CapturarValorDaTaxaDeJurosAnual();
            System.out.println("Taxa de juros: " + taxaJurosAnual + "%");

            String tipoZona = interfaceUsuario.CapturarTipoDeZona();
            System.out.println("O tipo de zona é: " + tipoZona);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-------------------------- INFORMAÇÕES DOS FINANCIAMENTOS -------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");

        double valorTotalDosImoveis;
        double valorTotalDosFinanciamentos;

        financiamentos.forEach(financiamento ->
        {
            int numeroDoFinanciamento = financiamentos.indexOf(financiamento) + 1;
            financiamento.RetornarInformacoesDoFinanciamento(numeroDoFinanciamento);
        });

        // utilizando o getter para acessar o atributo do valorDoImovel dentro da classe de Financiamento para fazer a soma

        valorTotalDosImoveis = financiamentos.stream().map(Financiamento::getValorDoImovel).reduce(0.0, Double::sum);
        valorTotalDosFinanciamentos = financiamentos.stream().map(Financiamento::CalcularTotalDoPagamento).reduce(0.0, Double::sum);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Valor total dos imóveis: R$ " + valorTotalDosImoveis);
        System.out.println("Valor total dos financiamentos: R$ " + valorTotalDosFinanciamentos);
        System.out.println("-----------------------------------------------------------------------------------------");


        financiamentos.add(new Terreno(valorDoImovel, prazoDeFinanciamento, taxaJurosAnual, tipoZona));

        try (FileWriter gravador = new FileWriter("AtpFinanciamentosPoo.txt")) {
            for (Financiamento financiamento : financiamentos) {
                gravador.write(financiamento.toString() + "\n");
            }
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Arquivo com dados dos financiamentos gerado com sucesso.");
            System.out.println("-----------------------------------------------------------------------------------------");
        } //capturar os erros
        catch (FileNotFoundException e)
            {
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("O arquivo não foi encontrado");
                System.out.println("-----------------------------------------------------------------------------------------");
            }
        catch (IOException e)
            {
                e.printStackTrace();
            }

        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream("ArrayAtpFinanciamentosPoo.dat")))
        {
            saida.writeObject(financiamentos);
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Array salvo com sucesso.");
            System.out.println("-----------------------------------------------------------------------------------------");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        ArrayList<Financiamento> dadosDosFinanciamentos = null;

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("ArrayAtpFinanciamentosPoo.dat")))
        {
            dadosDosFinanciamentos = (ArrayList<Financiamento>) entrada.readObject();
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("ArrayList carregado com sucesso: ");
            System.out.println("-----------------------------------------------------------------------------------------");

            dadosDosFinanciamentos.forEach(System.out::println);
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
