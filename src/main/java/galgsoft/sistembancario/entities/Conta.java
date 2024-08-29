package galgsoft.sistembancario.entities;

import galgsoft.sistembancario.dto.ContaDTO;
import galgsoft.sistembancario.enums.TipoContaEnum;
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

    @Enumerated(EnumType.STRING)
    private TipoContaEnum tipoConta;

    @OneToMany
    private List<Transacao> transacaos;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    public Conta(ContaDTO dto){
        this.numero = dto.numero();
        this.saldo = dto.saldo();
        this.tipoConta = dto.tipoConta();
        this.cliente = new Cliente();
        cliente.setId(dto.id());
    }

}
