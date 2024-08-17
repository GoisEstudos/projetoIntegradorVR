package galgsoft.sistembancario.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "cep", nullable = false, length = 9, unique = true)
    @Size(min = 9, max = 9, message = "O cep deve ter 9 caracteres")
    @NotBlank(message = "O nome nao pode ser nulo, ou estar em branco!")
    private String cep;

    @Column(name = "localidade", nullable = false)
    @Size(max = 255, message = "O endereco pode ter no maximo 255 caracteres")
    @NotBlank(message = "O nome nao pode ser nulo ou estar em branco!")
    private String localidade;

    @Column(name = "logradouro", nullable = false)
    @Size(max = 255, message = "O logradouro pode ter no maximo 255 caracteres")
    @NotBlank(message = "O nome nao pode ser nulo ou estar em branco!")
    private String logradouro;

    @Column(name = "uf", nullable = false, length = 2)
    @Size(min = 2, max = 2, message = "O uf deve ter 2 caracteres")
    @NotBlank(message = "O nome nao pode ser nulo ou estar em branco!")
    private String uf;
}
