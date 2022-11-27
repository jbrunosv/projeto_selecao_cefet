package service;

import entity.Funcionario;
import entity.Venda;
import entity.Vendedor;

import java.util.*;

public class CalculoService {

    //Questao 1
    //Um método que receba uma lista de funcionários, mês e ano e retorne o valor total
    //pago (salário e benefício) a esses funcionários no mês.
    public Double valorTotalPagoSalarioEBeneficioNoMesComVendas(List<Funcionario> funcionarios, String mesEAno){
        //Double beneficioVendedores = vendas.stream().mapToDouble(venda -> venda.obterBeneficio(mesEAno)).sum();
        Double salariosDeTodosOsFuncionarios = funcionarios.stream()
                .mapToDouble( funcionario -> funcionario.obterSalarioSemBeneficio(mesEAno))
                .sum();
        //System.out.println(salariosDeTodosOsFuncionarios);
        Double beneficios = funcionarios.stream()
                .mapToDouble(funcionario -> funcionario.obterBeneficio(mesEAno))
                .sum();
        return (salariosDeTodosOsFuncionarios + beneficios);
    }

    //Questao 2
    //Um método que receba uma lista de funcionários, mês e ano e retorne o total pago
    //somente em salários no mês.
    public Double valorTotalPagoSalarioNoMes(List<Funcionario> funcionarios, String mesEAno){

        Double somaTotalSalarios = funcionarios.stream()
                .mapToDouble(funcionario -> funcionario.obterSalarioSemBeneficio(mesEAno))
                .sum();

        return somaTotalSalarios;
    }

    //Questao 3
    //Um método que receba uma lista somente com os funcionários que recebem
    //benefícios, mês e ano e retorne o total pago em benefícios no mês.
    public Double valorTotalPagoEmBeneficioNoMes(List<Funcionario> funcionarios, String mesEAno){
        Double beneficio = funcionarios.stream()
                .mapToDouble(funcionario -> funcionario.obterBeneficio(mesEAno))
                .sum();

        return (beneficio);

    }

    //Questao 4
    //Um método que receba uma lista de funcionários, mês e ano e retorne o que
    //recebeu o valor mais alto no mês.
    public Funcionario funcionarioQueRecebeuValorMaisAlto(List<Funcionario> funcionarios, String mesEAno){

        Funcionario funcionarioQueFaturouMais = null;

        for(Funcionario f : funcionarios){
            if(funcionarioQueFaturouMais == null || f.obterSalarioComBeneficio(mesEAno) > funcionarioQueFaturouMais.obterSalarioComBeneficio(mesEAno)){
                funcionarioQueFaturouMais = f;
            }
        }

        return funcionarioQueFaturouMais;
    }

    //Questao 5
    //Um método que receba uma lista somente com os funcionários que recebem
    //benefícios, mês e ano e retorne o nome do funcionário que recebeu o valor mais
    //alto em benefícios no mês.
    public String funcionarioQueRecebeuMaisEmBeneficio(List<Funcionario> funcionarios, String mesEAno){

        Funcionario  nomeFuncionarioQueRecebeuMaisBeneficio = null;

        for(Funcionario f : funcionarios){
            if(nomeFuncionarioQueRecebeuMaisBeneficio == null || f.obterBeneficio(mesEAno) > nomeFuncionarioQueRecebeuMaisBeneficio.obterSalarioComBeneficio(mesEAno)){
                nomeFuncionarioQueRecebeuMaisBeneficio = f;
            }
        }

        return nomeFuncionarioQueRecebeuMaisBeneficio.getNome();

    }

    //Questao 6
    //Um método que receba uma lista de vendedores, mês e ano e retorne o que mais
    //vendeu no mês.
    public String vendedorQueMaisVendeuNoMes(List<Vendedor> vendedores, String mesEAno){

        Vendedor vendedorQueVendeuMaisNoMes = null;
        Double valorVenda = 0d;
        for(Vendedor v : vendedores){
            for(Venda venda : v.getVendas()){
                if(vendedorQueVendeuMaisNoMes == null || venda.getValorVenda() > valorVenda){
                    valorVenda = venda.getValorVenda();
                    vendedorQueVendeuMaisNoMes = v;
                }
            }
        }

        return vendedorQueVendeuMaisNoMes.getNome();

    }


}
