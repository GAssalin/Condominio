package br.com.condominio.condominio.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Morador {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoMorador tipo;

    @Enumerated(EnumType.STRING)
    private StatusMorador status;

    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;

}
