package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tb_assinatura")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "É necessário informar o nome da assinatura")
    private String nome;
    @NotNull(message = "Campo valor obrigatório")
    private Double valor;
    @Column(name = "ds_plano",length = 500)
    private @NotBlank String descrição;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Assinatura assinatura;


}