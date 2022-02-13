package org.rodrigo.rebeldes2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rodrigo.rebeldes2.enums.Raca;

@Data
@AllArgsConstructor
public class Rebelde {
    private String nome;
    private Integer idade;
    private Raca raca;
}
