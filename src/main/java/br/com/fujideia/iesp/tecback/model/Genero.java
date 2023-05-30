package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "É necessário informar o nome do gênero")
    private String nome;
    @OneToMany(mappedBy = "genero")
    private List<Filme> filmes;
    @OneToMany(mappedBy = "genero")
    private List<Serie> serie;
    //mapeando o relacionamento entre Genero e Filme, Gênero e Serie indicando
    // que um gênero pode ter vários filmes e series
    @NotNull(message = "O campo sinpose é obrigatório")
    @Column(name = "ds_sinopse",length = 500)
    private @NotBlank String sinopse;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

}
