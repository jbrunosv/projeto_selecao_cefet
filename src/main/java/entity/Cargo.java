package entity;

import entity.enums.Funcao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

    private Funcao nomeFuncao;
    private Double salario;
    private Double bonus;
    private Integer beneficio;

}
