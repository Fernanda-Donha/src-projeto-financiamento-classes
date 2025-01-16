package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable
{
    // Definiçao de tributos e nivel de acesso

    protected double valorDoImovel;
    protected int prazoDoFinanciamento;
    protected double taxaDeJurosAnual;

    // Metodo construtor para inicializar os atributos

    public Financiamento(double valorDoImovel, int prazoDoFinanciamento, double taxaDeJurosAnual)
    {
        this.valorDoImovel = valorDoImovel;
        this.prazoDoFinanciamento = prazoDoFinanciamento;
        this.taxaDeJurosAnual = taxaDeJurosAnual;
    }

    public double getValorDoImovel()
    {
        return valorDoImovel;
    }

    public int getPrazoDoFinanciamento()
    {
        return prazoDoFinanciamento;
    }

    public double getTaxaDeJurosAnual()
    {
        return taxaDeJurosAnual;
    }

    // Calculo do pagamento mensal

    public double CalcularPagamentoMensal()
    {
           return (valorDoImovel/(prazoDoFinanciamento * 12) * (1 + taxaDeJurosAnual/12));
    }

    // Calculo do pagamento total

    public double CalcularTotalDoPagamento()
    {
        return (CalcularPagamentoMensal() * prazoDoFinanciamento * 12);
    }

    public void RetornarInformacoesDoFinanciamento(int numeroDoFinanciamento)
    {
        double valorTotalDoFinanciamento = CalcularTotalDoPagamento();

        System.out.println("Financiamento " + numeroDoFinanciamento + " - " +
                "Valor do imóvel: R$ " + valorDoImovel + " - " +
                "Valor do financiamento: R$ " + valorTotalDoFinanciamento);
    }
}