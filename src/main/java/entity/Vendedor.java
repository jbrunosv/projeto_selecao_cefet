package entity;

import entity.enums.Funcao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Vendedor extends Funcionario{

    public Vendedor(String nome, String mesContratacao, List<Venda> vendas){
        super(nome, new Cargo(Funcao.VENDEDOR, 12000d, 1800d,30), YearMonth.parse(mesContratacao, DateTimeFormatter.ofPattern("MM/yyyy")));
        this.vendas = vendas;
    }

    private List<Venda> vendas;

   @Override
    public List<Venda> getVendas(){
        return this.vendas;
    }

    /*@Override
    public String obterVendasNoMes(String mesEAno){
        Venda venda = null;
        for( Venda v : vendas){
            if(v.getMesVenda().equals(mesEAno)){
                venda = v;
            }
        }

        return venda;
    }*/

    @Override
    public Double obterSalarioSemBeneficio(String mesEAno){
        return (this.getCargo().getSalario() + ((convertToYearMonth(mesEAno).getYear() - this.getDataDaContratacao().getYear()) * this.getCargo().getBonus()));
    }

    @Override
    public Double obterBeneficio(String mesEAno){
        Double beneficio = 0d;

        for( Venda v : vendas){
            if(v.getMesVenda().equals(convertToYearMonth(mesEAno))){
                beneficio = v.obterBeneficio();
            }
        }
        return beneficio;
    }
    @Override
    public Double obterSalarioComBeneficio(String mesEAno){
        return (obterSalarioSemBeneficio(mesEAno) + obterBeneficio(mesEAno));
    }

}
