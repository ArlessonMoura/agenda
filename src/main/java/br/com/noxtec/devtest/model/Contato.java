package br.com.noxtec.devtest.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "contato", schema = "desafio")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contato_id")
    private Long id;

    @Column(name = "contato_nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "contato_email", unique = true, length = 255)
    private String email;

    @Column(name = "contato_celular", unique = true, nullable = false, length = 11)
    private String celular;

    @Column(name = "contato_telefone", length = 10)
    private String telefone;

    @Column(name = "contato_sn_favorito", nullable = false, length = 1)
    private char favorito = 'N';

    @Column(name = "contato_sn_ativo", nullable = false, length = 1)
    private char ativo = 'S';

    @Column(name = "contato_dh_cad", nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();
}