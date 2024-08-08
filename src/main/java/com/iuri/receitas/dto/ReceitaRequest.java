package com.iuri.receitas.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReceitaRequest {

    private String titulo;
    private String ingredientes;
    private String instrucoes;
    private LocalDate dataCriacao;
}