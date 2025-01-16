package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    public java.lang.String String;
    // Instanciar a classe scanner para que ela possa ser utilizada em outras classes

    Scanner inputDoUsuario = new Scanner(System.in);

    public InterfaceUsuario()
    {

    }
    public double CapturarValorDoImovel()
    {
        return ReceberInputDoUsuario("Digite o valor do imóvel: ", false);
    }

    public int CapturarValorDoPrazoDoFinanciamentoEmAnos()
    {
        return (int) ReceberInputDoUsuario("Digite o prazo do financiamento (em ano(s)): ", true);
    }

    public double CapturarValorDaTaxaDeJurosAnual()
    {
        return ReceberInputDoUsuario("Digite o valor da taxa de juros: ", false);
    }

    public String CapturarTipoDeZona()
    {
        System.out.println("Digite o tipo de zona: ");
        return inputDoUsuario.next();
    }

    private double ReceberInputDoUsuario(String mensagemAoUsuario, boolean valorEhInteiro)
    {
        double valorInformadoPeloUsuario;

        // Sistema de validação para verificar se o valor que o usuario digitou é válido

        while(true)
        {
            try {
                System.out.println(mensagemAoUsuario);
                valorInformadoPeloUsuario = valorEhInteiro ? inputDoUsuario.nextInt() : inputDoUsuario.nextDouble();

                if (ValidarSeValorInseridoPeloUsuarioEhNumeroPositivo(valorInformadoPeloUsuario))
                    break;

                System.out.println("Não é permitido inserir valores negativos. Por favor, digite novamente.");

            } catch (InputMismatchException exception) {
                System.out.println("Valor inserido não é um número. Por favor, verifique e digite novamente.");
                inputDoUsuario.next();
            }
        }
        return valorInformadoPeloUsuario;
    }
    public boolean ValidarSeValorInseridoPeloUsuarioEhNumeroPositivo(double inputDoUsuario)
    {
        return inputDoUsuario >= 0;
    }
}