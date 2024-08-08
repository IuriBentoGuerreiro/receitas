package com.iuri.receitas.model;

import com.iuri.receitas.dto.ReceitaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "receita")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "ingredientes")
    private String ingredientes;
    @Column(name = "instrucoes")
    private String instrucoes;
    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    public static Receita converter(ReceitaRequest request){
        return Receita.builder()
                .titulo(request.getTitulo())
                .ingredientes(request.getIngredientes())
                .instrucoes(request.getInstrucoes())
                .dataCriacao(LocalDate.now())
                .build();
    }
}
