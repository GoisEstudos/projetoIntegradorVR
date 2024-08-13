package galgsoft.sistembancario.entities;

import galgsoft.sistembancario.enums.TipoTransacaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private TipoTransacaoEnum tipoTransacao;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_conta", referencedColumnName = "id")
    private Conta conta;

}
