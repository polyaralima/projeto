package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "É necessário informar o nome do usuário")
    private String nome;
    @NotBlank (message = "É neecessário informar o email do usuario")
    private String email;
    private @NotBlank String usuario;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;


}