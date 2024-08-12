package com.iuri.receitas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReceitaRequest {

    @NotBlank
    @Size(max = 255)
    private String titulo;
    @NotBlank
    @Size(max = 5000)
    private String ingredientes;
    @NotBlank
    @Size(max = 5000)
    private String instrucoes;
    @PastOrPresent
    private LocalDate dataCriacao;
}