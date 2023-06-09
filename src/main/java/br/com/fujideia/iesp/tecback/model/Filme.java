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
@Table(name = "tb_filme")
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "É necessário informar o título da fime")
    private String titulo;
    @NotNull(message = "O campo sinpose é obrigatório")
    @Column(name = "ds_sinopse",length = 500)
    private @NotBlank String sinopse;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;
}
