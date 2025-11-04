package br.leonardo.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.leonardo.catalogo.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
