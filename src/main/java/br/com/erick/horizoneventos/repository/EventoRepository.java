package br.com.erick.horizoneventos.repository;

import br.com.erick.horizoneventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
