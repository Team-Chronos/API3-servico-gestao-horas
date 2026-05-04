package com.api.controle_horas.modelos.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class RegistrosHorasDto implements Serializable {

  private List<ControleHorasDto> registros;
  private Long tempoMinutos;
}