package galgsoft.sistembancario.entities;

import galgsoft.sistembancario.enums.CargoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String cpf;

    private CargoEnum cargo;

    @ManyToOne
    @JoinColumn(name = "id_agencia")
    private Agencia agencia;

}
