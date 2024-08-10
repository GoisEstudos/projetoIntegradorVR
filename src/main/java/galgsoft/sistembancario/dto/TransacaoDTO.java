package galgsoft.sistembancario.dto;

import galgsoft.sistembancario.enums.TipoTransacaoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransacaoDTO(UUID id, LocalDateTime data, TipoTransacaoEnum tipoTransacao, BigDecimal valor, String idConta) {
}
