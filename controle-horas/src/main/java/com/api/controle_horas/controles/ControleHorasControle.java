package com.api.controle_horas.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.controle_horas.modelos.dto.ControleHorasDto;
import com.api.controle_horas.modelos.dto.ControleHorasRequestDto;
import com.api.controle_horas.modelos.dto.RegistrosHorasDto;
import com.api.controle_horas.servicos.AtualizadorControleHoras;
import com.api.controle_horas.servicos.BuscadorControleHoras;
import com.api.controle_horas.servicos.CriadorControleHoras;
import com.api.controle_horas.servicos.ExcluidorControleHoras;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/registros")
public class ControleHorasControle {
  
  @Autowired
  BuscadorControleHoras buscador;
  @Autowired
  CriadorControleHoras criador;
  @Autowired
  AtualizadorControleHoras atualizador;
  @Autowired
  ExcluidorControleHoras excluidor;

  @GetMapping("/tarefa/{tarefa_id}")
  public RegistrosHorasDto buscarPorTarefa(@PathVariable Long tarefa_id){
    return buscador.buscarPorTarefa(tarefa_id);
  }
  
  @GetMapping("/{id}")
  public ControleHorasDto buscarPorId(@PathVariable Long id){
    return buscador.buscarPorId(id);
  }

  @PostMapping
  public void criar(@RequestBody @Valid ControleHorasRequestDto requestDto){
    criador.criar(requestDto);
  }

  @PutMapping("/{id}")
  public void atualizar(@PathVariable Long id, @RequestBody ControleHorasRequestDto requestDto){
    atualizador.atualizar(id, requestDto);
  }

  @DeleteMapping("/{id}")
  public void deletar(@PathVariable Long id){
    excluidor.excluir(id);
  }
}
