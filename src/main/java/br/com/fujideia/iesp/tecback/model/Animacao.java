package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_animacao")
public class Animacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "É necessário informar a animação desejada ")
    private String nome;
    @NotNull(message = "O campo sinpose é obrigatório")
    @Column(name = "ds_sinopse",length = 500)
    private @NotBlank String sinopse;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

}