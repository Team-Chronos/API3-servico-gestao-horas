package com.api.controle_horas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.controle_horas.modelos.entidades.ControleHoras;

public interface ControleHorasRepositorio extends JpaRepository<ControleHoras, Long> {

  List<ControleHoras> findByTarefaId(Long tarefaId);
}
