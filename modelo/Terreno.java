package modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable
{

    private String tipoZona;

    double taxaDeAcrescimo = 0.2;

    public Terreno(double valorDoImovel, int prazoDoFinanciamento, double taxaDeJurosAnual, String tipoZona)
    {
        super(valorDoImovel, prazoDoFinanciamento, taxaDeJurosAnual);
    }

    public double CalcularPagamentoMensal()
    {
        return super.CalcularPagamentoMensal() * taxaDeAcrescimo;
    }

    @Override
    public String toString() {
        return "Terreno: " +
                "Valor do Imóvel: " + "R$:" + valorDoImovel + ", \n" +
                "Prazo do Financiamento: " + prazoDoFinanciamento + " anos" + ", \n" +
                "Taxa de Juros: " + taxaDeJurosAnual + "%" + ", \n" +
                "Tipo de Zona : " + tipoZona;
    }

}
