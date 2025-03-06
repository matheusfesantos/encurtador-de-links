package br.encurtador.repository;

import br.encurtador.entity.urlEncurtada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface URLEncurtadaRepos extends JpaRepository<urlEncurtada, Long>
{
    Optional<urlEncurtada> findCodigoCurto(String codigoCurto);
}
