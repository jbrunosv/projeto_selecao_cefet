package entity;

import entity.enums.Funcao;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Secretario extends Funcionario{

    public Secretario(String nome, String mesContratacao){
        super(nome, new Cargo(Funcao.SECRETARIO, 7000d, 1000d,20), YearMonth.parse(mesContratacao, DateTimeFormatter.ofPattern("MM/yyyy")));
    }

    @Override
    public Double obterSalarioSemBeneficio(String mesEAno){
        return (this.getCargo().getSalario() + ((convertToYearMonth(mesEAno).getYear() - this.getDataDaContratacao().getYear()) * this.getCargo().getBonus()));
    }

    @Override
    public Double obterBeneficio(String mesEAno){
        return (obterSalarioSemBeneficio(mesEAno) + (this.getCargo().getBeneficio() / 100));
    }

    public Double obterSalarioComBeneficio(String mesEAno){
        return (obterSalarioSemBeneficio(mesEAno) + obterBeneficio(mesEAno));
    }
}
