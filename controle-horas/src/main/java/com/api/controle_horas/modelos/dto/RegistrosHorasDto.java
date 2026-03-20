package com.api.controle_horas.modelos.dto;

import java.util.List;

import lombok.Data;

@Data
public class RegistrosHorasDto {
  
  private List<ControleHorasDto> registros;

  private Long tempoMinutos;
}
