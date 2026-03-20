package com.api.controle_horas.servicos;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Service;

import com.api.controle_horas.modelos.dto.ControleHorasDto;

@Service
public class CalculadorTempo {

  public Duration calcularTempo(Instant data_inicio, Instant data_fim) {
    if (data_inicio == null || data_fim == null)
      return null;
    return Duration.between(data_inicio, data_fim);
  }

  public Duration aplicarTempo(ControleHorasDto dto) {
    Duration duracao = calcularTempo(dto.getData_inicio(), dto.getData_fim());

    if (duracao != null) {
      dto.setTempoMinutos(duracao.toMinutes());
    }

    return duracao;
  }
}
