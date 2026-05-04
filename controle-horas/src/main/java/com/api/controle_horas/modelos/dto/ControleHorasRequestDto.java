package com.api.controle_horas.modelos.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ControleHorasRequestDto {

    @NotNull(message = "Tarefa id não pode ser nulo")
    @JsonProperty("tarefa_id")
    private Long tarefa_id;

    @JsonProperty("data_inicio")
    private Instant data_inicio;

    @JsonProperty("data_fim")
    private Instant data_fim;
}