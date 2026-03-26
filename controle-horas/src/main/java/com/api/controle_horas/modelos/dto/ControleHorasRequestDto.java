package com.api.controle_horas.modelos.dto;

import java.time.Instant;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ControleHorasRequestDto {
  
  @NotNull(message="Tarefa id não pode ser nulo")
  private Long tarefa_id;
  
  private Instant data_inicio;
  private Instant data_fim;

}
