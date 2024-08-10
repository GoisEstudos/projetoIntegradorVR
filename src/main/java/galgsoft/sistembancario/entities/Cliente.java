package galgsoft.sistembancario.entities;

import galgsoft.sistembancario.dto.ClienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

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

    @Size(max = 255, message = "O nome nao pode conter mais que 255 caracteres!")
    @NotBlank(message = "O nome nao pode ser nullo ou estar em branco!")
    private String nome;

    @CPF
    @NotBlank
    private String cpf;

    @OneToMany
    private List<Conta> contas;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;


    public Cliente(ClienteDTO dto) {
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.endereco = new Endereco();
        this.endereco.setId(dto.idEndereco());
    }
}
