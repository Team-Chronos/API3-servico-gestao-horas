package com.api.controle_horas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.controle_horas.modelos.dto.ControleHorasRequestDto;
import com.api.controle_horas.modelos.entidades.ControleHoras;
import com.api.controle_horas.repositorios.ControleHorasRepositorio;

@Service
public class AtualizadorControleHoras {
  
  @Autowired
  ControleHorasRepositorio repositorio;

  private void atualizarRegistro(ControleHorasRequestDto atualizacao, ControleHoras registro){
    if (atualizacao.getData_inicio() != null){
      registro.setData_inicio(atualizacao.getData_inicio());
    }

    if (atualizacao.getData_fim() != null){
      registro.setData_fim(atualizacao.getData_fim());
    }
  }

  public void atualizar(Long id, ControleHorasRequestDto requestDto){
    ControleHoras controleHoras = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    atualizarRegistro(requestDto, controleHoras);
    repositorio.save(controleHoras);
  }
}
