package galgsoft.sistembancario.dto;

import galgsoft.sistembancario.enums.TipoContaEnum;

import java.math.BigDecimal;
import java.util.UUID;

public record ContaDTO(UUID id, String numero, BigDecimal saldo, TipoContaEnum tipoConta, String idCliente) {
}
