package com.api.controle_horas.modelos.dto;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data
public class ControleHorasDto implements Serializable {

  private Long id;
  private Long tarefa_id;
  private Instant data_inicio;
  private Instant data_fim;
  private Long tempoMinutos;
}