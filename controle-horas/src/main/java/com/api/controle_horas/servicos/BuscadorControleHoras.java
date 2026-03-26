package com.api.controle_horas.servicos;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.controle_horas.mappers.ControleHorasMapper;
import com.api.controle_horas.modelos.dto.ControleHorasDto;
import com.api.controle_horas.modelos.dto.RegistrosHorasDto;
import com.api.controle_horas.modelos.entidades.ControleHoras;
import com.api.controle_horas.repositorios.ControleHorasRepositorio;

@Service
public class BuscadorControleHoras {

  @Autowired
  ControleHorasRepositorio repositorio;

  @Autowired
  CalculadorTempo calculadorTempo;

  public ControleHorasDto buscarPorId(Long id) {
    ControleHoras controleHoras = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));

    ControleHorasDto controleHorasDto = ControleHorasMapper.toDto(controleHoras);

    calculadorTempo.aplicarTempo(controleHorasDto);

    return controleHorasDto;
  }

  public RegistrosHorasDto buscarPorTarefa(Long tarefa_id) {
    List<ControleHoras> controleHorases = repositorio.findByTarefaId(tarefa_id);
    RegistrosHorasDto registrosHorasDto = ControleHorasMapper.toRegistroDto(controleHorases);
    Duration tempoTotal = Duration.ZERO;
    for (ControleHorasDto controleHorasDto : registrosHorasDto.getRegistros()) {

      Duration tempo = calculadorTempo.aplicarTempo(controleHorasDto);

      if (tempo != null) {
        tempoTotal = tempoTotal.plus(tempo);
      }
    }
    registrosHorasDto.setTempoMinutos(tempoTotal.toMinutes());
    return registrosHorasDto;
  }

  public List<ControleHorasDto> buscarTodos(){
    List<ControleHoras> controleHorases = repositorio.findAll();
    List<ControleHorasDto> dtos = ControleHorasMapper.toDto(controleHorases);
    dtos.forEach(
      dto -> calculadorTempo.aplicarTempo(dto)
    );
    return dtos;
  }
}
