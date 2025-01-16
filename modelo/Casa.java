package modelo;

import util.AcrescimoMaiorDoQueJurosException;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable
{
    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorDoImovel, int prazoDoFinanciamento, double taxaDeJurosAnual, double areaConstruida, double areaTerreno)
    {
        super(valorDoImovel, prazoDoFinanciamento, taxaDeJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    private void validarSeAcrescimoSeguroEhMaiorQueJuros(double taxaDeJurosAnual, double taxaDeSeguroObrigatorio) throws AcrescimoMaiorDoQueJurosException
    {
        if (taxaDeSeguroObrigatorio > taxaDeJurosAnual)
        {
            throw new AcrescimoMaiorDoQueJurosException("A taxa de seguro obrigatória não pode ser maior do que a taxa de juros anual");
        }
    }

    public double CalcularPagamentoMensal()
    {
        // obter o valor dos juros
        // obter o valor do acrescimo
        double taxaDeJurosAnual = 40;
        double taxaDeSeguroObrigatorio = 80;

        try
        {
            validarSeAcrescimoSeguroEhMaiorQueJuros(taxaDeJurosAnual,taxaDeSeguroObrigatorio);
        } catch (AcrescimoMaiorDoQueJurosException e)
        {
            taxaDeSeguroObrigatorio = taxaDeJurosAnual;
        }

        return super.CalcularPagamentoMensal() + taxaDeSeguroObrigatorio;
    }

    @Override
    public String toString() {
        return "Casa: " +
                "Valor do Imóvel: " + "R$:" + valorDoImovel + ", \n" +
                "Prazo do Financiamento: " + prazoDoFinanciamento + " anos" + ", \n" +
                "Taxa de Juros: " + taxaDeJurosAnual + "%" + ", \n" +
                "Área Construída: " + areaConstruida + " m2" + ", \n" +
                "Área do Terreno: " + areaTerreno + " m2" + "\n";
    }
}