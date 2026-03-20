package com.api.controle_horas.modelos.entidades;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ControleHoras {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column
  private Long tarefa_id;

  @Column
  private Instant data_inicio;

  @Column(nullable=true)
  private Instant data_fim;
  
}
