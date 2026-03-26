package com.api.controle_horas.mappers;

import java.util.ArrayList;
import java.util.List;

import com.api.controle_horas.modelos.dto.ControleHorasDto;
import com.api.controle_horas.modelos.dto.ControleHorasRequestDto;
import com.api.controle_horas.modelos.dto.RegistrosHorasDto;
import com.api.controle_horas.modelos.entidades.ControleHoras;

public class ControleHorasMapper {
  
  public static ControleHoras toEntity(ControleHorasRequestDto requestDto){
    ControleHoras controleHoras = new ControleHoras();
    controleHoras.setTarefaId(requestDto.getTarefa_id());
    controleHoras.setData_inicio(requestDto.getData_inicio());
    controleHoras.setData_fim(requestDto.getData_fim());
    return controleHoras;
  }

  public static ControleHorasDto toDto(ControleHoras controleHoras){
    ControleHorasDto controleHorasDto = new ControleHorasDto();
    controleHorasDto.setId(controleHoras.getId());
    controleHorasDto.setTarefa_id(controleHoras.getTarefaId());
    controleHorasDto.setData_inicio(controleHoras.getData_inicio());
    controleHorasDto.setData_fim(controleHoras.getData_fim());
    return controleHorasDto;
  }

  public static List<ControleHorasDto> toDto(List<ControleHoras> controleHorases){
    List<ControleHorasDto> dtos = new ArrayList<>();

    for (ControleHoras controleHoras : controleHorases){
      dtos.add(toDto(controleHoras));
    }
    return dtos;
  }

  public static RegistrosHorasDto toRegistroDto(List<ControleHoras> controleHorases){
    RegistrosHorasDto registrosHorasDto = new RegistrosHorasDto();
    List<ControleHorasDto> controleHorasDtos = new ArrayList<>();
    for (ControleHoras controleHoras : controleHorases) {
      controleHorasDtos.add(ControleHorasMapper.toDto(controleHoras));
    }
    registrosHorasDto.setRegistros(controleHorasDtos);
    return registrosHorasDto;
  }
}
