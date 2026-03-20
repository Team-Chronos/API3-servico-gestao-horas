package com.api.controle_horas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.controle_horas.repositorios.ControleHorasRepositorio;

@Service
public class ExcluidorControleHoras {
  
  @Autowired
  ControleHorasRepositorio repositorio;

  public void excluir(Long id){
    repositorio.deleteById(id);
  }
}
