package galgsoft.sistembancario.entities;

import galgsoft.sistembancario.dto.ClienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @Column(name = "nome", nullable = false)
    @Size(max = 255, message = "O nome nao pode conter mais que 255 caracteres!")
    @NotBlank(message = "O nome nao pode ser nulo ou estar em branco!")
    private String nome;

    @Column(name = "cpf", nullable = false)
    @NotBlank(message = "O Cpf nao pode ser nulo ou estar em branco!")
    private String cpf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conta> contas;

    @ManyToOne
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private Endereco endereco;

    public Cliente(ClienteDTO dto) {
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.endereco = new Endereco();
        this.endereco.setCep(endereco.getCep());
    }
}
