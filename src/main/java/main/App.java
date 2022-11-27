package main;

import entity.*;
import service.CalculoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        //Cadastro de Secretários
        Funcionario jorgeCarvalho = new Secretario("Jorge Carvalho", "01/2018");
        Funcionario mariaSouza = new Secretario("Maria Souza", "12/2015");

        //Registro de Vendas
        List<Venda> vendasAnaSilva = new ArrayList<>(Arrays.
                asList(
                        new Venda("12/2021", 5200d),
                        new Venda("01/2022", 4000d),
                        new Venda("02/2022", 4200d),
                        new Venda("03/2022", 5850d),
                        new Venda("04/2022", 7000d)
                ));

        List<Venda> vendasJoaoMendes = new ArrayList<>(Arrays.
                asList(
                        new Venda("12/2021", 3400d),
                        new Venda("01/2022", 7700d),
                        new Venda("02/2022", 5000d),
                        new Venda("03/2022", 5900d),
                        new Venda("04/2022", 6500d)
                ));

        //Cadastro de vendedores
        Funcionario anaSilva = new Vendedor("Ana Silva", "12/2021", vendasAnaSilva);
        Vendedor vAnaSilva = new Vendedor("Ana Silva", "12/2021", vendasAnaSilva);
        Funcionario joaoMendes = new Vendedor("João Mendes", "12/2021", vendasJoaoMendes);
        Vendedor vJoaoMendes = new Vendedor("João Mendes", "12/2021", vendasJoaoMendes);

        //Cadastro de Gerentes
        Funcionario julianaAlves = new Gerente("Juliana Alves", "07/2017");
        Funcionario bentoAlbino = new Gerente("Bento Albino", "03/2014");

        //Criando a lista de Funcionarios
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(jorgeCarvalho, mariaSouza, anaSilva, joaoMendes, julianaAlves, bentoAlbino));
        List<Vendedor> vendedores = new ArrayList<>(Arrays.asList(vAnaSilva, vJoaoMendes));


        //System.out.println("\nFuncionarios: "+ funcionarios.toString());

        CalculoService service = new CalculoService();

        //Q1 OK
        System.out.println("\nQuestão 1:\nO valor total pago (salário e benefício) no mês informado foi: " + service.valorTotalPagoSalarioEBeneficioNoMesComVendas(funcionarios, "01/2022"));

        //Q2 OK
        System.out.println("\nQuestão 2:\nO total pago somente em salários no mês foi: " + service.valorTotalPagoSalarioNoMes(funcionarios, "01/2022"));

        //Q3 OK
        System.out.println("\nQuestão 3:\nO total pago em benefícios no mês foi: "+ service.valorTotalPagoEmBeneficioNoMes(funcionarios, "01/2022"));

        //Q4 OK
        System.out.println("\nQuestão 4:\nO funcionario que recebeu o valor mais alto no mês foi: "+ service.funcionarioQueRecebeuValorMaisAlto(funcionarios, "01/2022").getNome());

        //Q5 OK
        System.out.println("\nQuestão 5:\nO nome do funcionário que recebeu o valor mais alto em benefícios no mês foi: " + service.funcionarioQueRecebeuMaisEmBeneficio(funcionarios, "01/2022"));

        //Q6 Quebrado
        System.out.println("\nQuestão 6:\nO vendedor que mais vendeu no mês foi: " + service.vendedorQueMaisVendeuNoMes(vendedores, "01/2022"));
    }
}
