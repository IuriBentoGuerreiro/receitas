package com.iuri.receitas.service;

import com.iuri.receitas.dto.ReceitaRequest;
import com.iuri.receitas.dto.ReceitaResponse;
import com.iuri.receitas.model.Receita;
import com.iuri.receitas.repository.ReceitaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public ReceitaResponse salvar(ReceitaRequest request){
        return ReceitaResponse.converter(receitaRepository.save(Receita.converter(request)));
    }

    public List<ReceitaResponse> listar(){
        return receitaRepository.findAll().stream()
                .map(ReceitaResponse::converter).toList();
    }

    public Receita pegarPorId(Integer id){
        return receitaRepository.findById(id).orElseThrow();
    }

    public Receita atualizar(Integer id, ReceitaRequest request){
        var receitaSalva = pegarPorId(id);
        BeanUtils.copyProperties(request, receitaSalva, "id");
        return receitaRepository.save(receitaSalva);
    }

    public void deletar(Integer id){
        receitaRepository.deleteById(id);
    }
}
