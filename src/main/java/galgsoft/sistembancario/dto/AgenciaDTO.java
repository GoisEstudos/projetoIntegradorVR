package galgsoft.sistembancario.dto;

import java.util.List;
import java.util.UUID;

public record AgenciaDTO(UUID id, String numero, EnderecoDTO enderecoDTO, List<FuncionarioDTO> funcionarioDTO) {
}
