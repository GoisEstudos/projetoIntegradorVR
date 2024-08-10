package galgsoft.sistembancario.entities;

import galgsoft.sistembancario.dto.EnderecoDTO;
import jakarta.persistence.*;
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

    private String rua;

    private String cidade;

    private String estado;

    private String cep;

    public Endereco(EnderecoDTO dto){
        this.rua = dto.rua();
        this.cidade = dto.cidade();
        this.estado = dto.estado();
        this.cep = dto.cep();
    }
}
