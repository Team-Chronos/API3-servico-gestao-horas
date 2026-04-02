package com.api.controle_horas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.api.controle_horas.mappers.ControleHorasMapper;
import com.api.controle_horas.modelos.dto.ControleHorasRequestDto;
import com.api.controle_horas.modelos.entidades.ControleHoras;
import com.api.controle_horas.repositorios.ControleHorasRepositorio;

@Service
public class CriadorControleHoras {

  @Autowired
  ControleHorasRepositorio repositorio;

  public void criar(ControleHorasRequestDto requestDto) {
    RestTemplate restTemplate = new RestTemplate();

    try {
      restTemplate.getForObject(
        "http://localhost:8089/tarefas/" + requestDto.getTarefa_id(),
        String.class
      );

      if (requestDto.getData_inicio().isAfter(requestDto.getData_fim())) {
        throw new IllegalArgumentException("Data de início não pode ser posterior à data de fim");
      }

      ControleHoras controleHoras = ControleHorasMapper.toEntity(requestDto);
      repositorio.save(controleHoras);

    } catch (RestClientException e) {
      throw new RuntimeException("Tarefa não encontrada");
    }
  }
}
