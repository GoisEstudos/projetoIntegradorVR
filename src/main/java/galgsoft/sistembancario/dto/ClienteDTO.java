package galgsoft.sistembancario.dto;

import java.util.UUID;

public record ClienteDTO(UUID id, String nome, String cpf, UUID idEndereco) {
}
