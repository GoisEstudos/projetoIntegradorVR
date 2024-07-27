package galgsoft.sistembancario.entities;

import galgsoft.sistembancario.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String cpf;

    @OneToMany
    private List<Conta> contas;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;


    public Cliente(ClienteDTO dto) {
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.endereco = new Endereco(
                null,
                dto.enderecodto().rua(),
                dto.enderecodto().cidade(),
                dto.enderecodto().estado(),
                dto.enderecodto().cep()
        );
    }
}
