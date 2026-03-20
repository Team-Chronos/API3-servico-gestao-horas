package com.api.controle_horas.mappers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.api.controle_horas.modelos.dto.ControleHorasDto;
import com.api.controle_horas.modelos.dto.ControleHorasRequestDto;
import com.api.controle_horas.modelos.dto.RegistrosHorasDto;
import com.api.controle_horas.modelos.entidades.ControleHoras;

public class ControleHorasMapper {
  
  public static ControleHoras toEntity(ControleHorasRequestDto requestDto){
    ControleHoras controleHoras = new ControleHoras();
    controleHoras.setTarefa_id(requestDto.getTarefa_id());
    controleHoras.setData_inicio(requestDto.getData_inicio());
    controleHoras.setData_fim(requestDto.getData_fim());
    return controleHoras;
  }

  public static ControleHorasDto toDto(ControleHoras controleHoras){
    ControleHorasDto controleHorasDto = new ControleHorasDto();
    controleHorasDto.setId(controleHoras.getId());
    controleHorasDto.setTarefa_id(controleHoras.getTarefa_id());
    controleHorasDto.setData_inicio(controleHoras.getData_inicio());
    controleHorasDto.setData_fim(controleHoras.getData_fim());
    controleHorasDto.setTempo(
      Duration.between(controleHoras.getData_inicio(), controleHoras.getData_fim())
    );
    return controleHorasDto;
  }

  public static RegistrosHorasDto toDto(List<ControleHoras> controleHorases){
    RegistrosHorasDto registrosHorasDto = new RegistrosHorasDto();
    List<ControleHorasDto> controleHorasDtos = new ArrayList<>();
    for (ControleHoras controleHoras : controleHorases) {
      controleHorasDtos.add(ControleHorasMapper.toDto(controleHoras));
    }
    registrosHorasDto.setRegistros(controleHorasDtos);
    return registrosHorasDto;
  }
}
