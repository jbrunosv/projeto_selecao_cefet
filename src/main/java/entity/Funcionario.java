package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public abstract class Funcionario {
/*
    public Funcionario(String nome, Cargo cargo, String  dataDaContratacao){
        this.nome = nome;
        this.cargo = cargo;
        this.dataDaContratacao = YearMonth.parse(dataDaContratacao, DateTimeFormatter.ofPattern("MM/yyyy"));
    }*/

    private String nome;
    private Cargo cargo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yyyy")
    private YearMonth dataDaContratacao;

    public Double obterSalarioSemBeneficio(String mesEAno) {
        return null;
    }

    public Double obterBeneficio(String mesEAno){
        return null;
    }

    public List<Venda> getVendas(){
        return null;
    }

    /*public String obterVendasNoMes(String mesEAno){
        return "Teste";
    }*/

    public Double obterSalarioComBeneficio(String mesEAno){
        return null;
    }

    public YearMonth convertToYearMonth(String mesEAno){
        return YearMonth.parse(mesEAno, DateTimeFormatter.ofPattern("MM/yyyy"));
    }
}
