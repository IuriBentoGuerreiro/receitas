package com.iuri.receitas.dto;

import com.iuri.receitas.model.Receita;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReceitaResponse {

    private Integer id;
    private String titulo;
    private String ingredientes;
    private String instrucoes;
    private LocalDate dataCriacao;

    public static ReceitaResponse converter(Receita receita){
        return ReceitaResponse.builder()
                .id(receita.getId())
                .titulo(receita.getTitulo())
                .ingredientes(receita.getIngredientes())
                .instrucoes(receita.getInstrucoes())
                .dataCriacao(LocalDate.now())
                .build();
    }
}
