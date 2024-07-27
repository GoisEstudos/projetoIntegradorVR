package galgsoft.sistembancario.dto;

import galgsoft.sistembancario.enums.TipoContaEnum;

import java.math.BigDecimal;

public record ContaDTO(String numero, BigDecimal saldo, TipoContaEnum tipoConta, TransacaoDTO transacaos, String idCliente) {
}
