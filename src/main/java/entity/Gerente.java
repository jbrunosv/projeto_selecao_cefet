package entity;

import entity.enums.Funcao;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Gerente extends Funcionario{

    public Gerente(String nome, String mesContratacao){
        super(nome, new Cargo(Funcao.GERENTE, 20000d, 3000d,0), YearMonth.parse(mesContratacao, DateTimeFormatter.ofPattern("MM/yyyy")) );
    }

    @Override
    public Double obterSalarioSemBeneficio(String mesEAno){
        return (this.getCargo().getSalario() + ((convertToYearMonth(mesEAno).getYear() - (this.getDataDaContratacao().getYear())) * this.getCargo().getBonus()));
    }

    @Override
    public Double obterSalarioComBeneficio(String mesEAno){
        return obterSalarioSemBeneficio(mesEAno);
    }

    @Override
    public Double obterBeneficio(String mesEAno){
        return 0d ;
    }
}
