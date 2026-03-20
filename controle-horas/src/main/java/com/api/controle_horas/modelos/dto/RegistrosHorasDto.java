package com.api.controle_horas.modelos.dto;

import java.time.Duration;
import java.util.List;

import lombok.Data;

@Data
public class RegistrosHorasDto {
  
  private List<ControleHorasDto> registros;

  private Duration tempo;
}
