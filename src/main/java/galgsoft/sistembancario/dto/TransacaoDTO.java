package galgsoft.sistembancario.dto;

import galgsoft.sistembancario.enums.TipoTransacaoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoDTO(LocalDateTime data, TipoTransacaoEnum tipoTransacao, BigDecimal valor, String idConta) {
}
