package br.com.noxtec.devtest.service;

import br.com.noxtec.devtest.model.Contato;
import br.com.noxtec.devtest.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> buscarPorId(Long id) {
        return contatoRepository.findById(id);
    }

    public Optional<Contato> buscarPorCelular(String celular) {
        return contatoRepository.findByCelular(celular);
    }

    //TODO: pesquisar por nome e email

    public Contato salvar(Contato contato) {
        if (contatoRepository.findByCelular(contato.getCelular()).isPresent()) {
            throw new RuntimeException("Já existe um contato com este número de celular.");
        }
        return contatoRepository.save(contato);
    }

    public Contato atualizar(Long id, Contato contatoAtualizado) {
        return contatoRepository.findById(id).map(contato -> {
            contato.setNome(contatoAtualizado.getNome());
            contato.setEmail(contatoAtualizado.getEmail());
            contato.setCelular(contatoAtualizado.getCelular());
            contato.setTelefone(contatoAtualizado.getTelefone());
            contato.setFavorito(contatoAtualizado.getFavorito());
            contato.setAtivo(contatoAtualizado.getAtivo());
            return contatoRepository.save(contato);
        }).orElseThrow(() -> new RuntimeException("Contato não encontrado."));
    }

    public void deletar(Long id) {
        contatoRepository.deleteById(id);
    }
}
