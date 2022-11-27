package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    public Venda( String mesVenda, Double valorVenda) {
        this.mesVenda = YearMonth.parse(mesVenda, DateTimeFormatter.ofPattern("MM/yyyy"));
        this.valorVenda = valorVenda;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yyyy")
    private YearMonth mesVenda;
    private Double valorVenda;


    public Double obterBeneficio(){
            return (0.3 * this.valorVenda);
    }

   /*public Double obterBeneficioPorNomeVendedorEData(String nome, String mesEAno){
            return obterBeneficio(mesEAno);
    }

    private void verificaVendedor(Funcionario funcionario) {
        if(!funcionario.getCargo().getNomeFuncao().equals(Funcao.VENDEDOR)){
            throw new MensagemException("O Funcionário "+ funcionario.getNome() +" não é um vendedor.");
        }
    }*/

}
