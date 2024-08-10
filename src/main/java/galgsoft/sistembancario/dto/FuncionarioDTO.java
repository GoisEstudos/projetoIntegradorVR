package galgsoft.sistembancario.dto;

import galgsoft.sistembancario.enums.CargoEnum;

import java.util.UUID;

public record FuncionarioDTO(UUID id, String nome, String cpf, CargoEnum cargoEnum, AgenciaDTO agenciaDTO) {
}
