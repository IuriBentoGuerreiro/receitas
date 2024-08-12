package com.iuri.receitas.controller;

import com.iuri.receitas.dto.ReceitaRequest;
import com.iuri.receitas.dto.ReceitaResponse;
import com.iuri.receitas.service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReceitaResponse salvar(@Valid @RequestBody ReceitaRequest request){
        return receitaService.salvar(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReceitaResponse> listar(){
        return receitaService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReceitaResponse pegarPorId(@PathVariable Integer id){
        return ReceitaResponse.converter(receitaService.pegarPorId(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ReceitaResponse atualizar(@Valid @PathVariable Integer id, @RequestBody ReceitaRequest request){
        return ReceitaResponse.converter(receitaService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        receitaService.deletar(id);
    }
}
