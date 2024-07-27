package galgsoft.sistembancario.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String numero;

    private BigDecimal saldo;

    private TipoConta tipo;

    @OneToMany
    private List<Transacao> transacaos;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
