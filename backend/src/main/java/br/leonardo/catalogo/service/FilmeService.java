package br.leonardo.catalogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.leonardo.catalogo.model.Filme;
import br.leonardo.catalogo.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public List<Filme> listarTodos() {
        return repository.findAll();
    }

    public Optional<Filme> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Filme salvar(Filme filme) {
        return repository.save(filme);
    }

    public Filme atualizar(Long id, Filme novoFilme) {
        return repository.findById(id).map(filme -> {
            filme.setTitulo(novoFilme.getTitulo());
            filme.setGenero(novoFilme.getGenero());
            filme.setDiretor(novoFilme.getDiretor());
            filme.setAnoLancamento(novoFilme.getAnoLancamento());
            filme.setAvaliacao(novoFilme.getAvaliacao());
            return repository.save(filme);
        }).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
