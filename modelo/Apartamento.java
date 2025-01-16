package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable
{
    private int numeroDeVagas;
    private int numeroDoAndar;

    public Apartamento(double valorDoImovel, int prazoDoFinanciamento, double taxaDeJurosAnual, int numeroDeVagas, int numeroDoAndar)
    {
        super(valorDoImovel, prazoDoFinanciamento, taxaDeJurosAnual);
    }

    public double CalcularPagamentoMensal()
    {
        // calcular a taxa de juros mensal
        double taxaJurosAnualApartamento = super.getTaxaDeJurosAnual();
        double taxaJurosMensal = (taxaJurosAnualApartamento / 12);
        // calcular o financiamento em meses
        int meses = (super.getPrazoDoFinanciamento() * 12);
        // aplicar a formula
        double valorDoApartamento = super.getValorDoImovel();
        double primeiraParteDaFormula = valorDoApartamento * Math.pow(1+taxaJurosMensal, meses);
        double segundaParteDaFormula = Math.pow(1 + taxaJurosMensal, meses) - 1;
        return primeiraParteDaFormula / segundaParteDaFormula;
    }

    @Override
    public String toString() {
        return "Apartamento: " +
                "Valor do Imóvel: " + "R$:" + valorDoImovel + ", \n" +
                "Prazo do Financiamento: " + prazoDoFinanciamento + " anos" + ", \n" +
                "Taxa de Juros: " + taxaDeJurosAnual + "%" + ", \n" +
                "Número de Vagas: " + numeroDeVagas + ", \n" +
                "Número do Andar: " + numeroDoAndar + "°" + "\n";
    }
}
