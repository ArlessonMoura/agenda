package br.com.noxtec.devtest.repository;

import br.com.noxtec.devtest.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Optional<Contato> findByCelular(String celular);
    Optional<Contato> findByNome(String nome);
    Optional<Contato> findByEmail(String email);
}