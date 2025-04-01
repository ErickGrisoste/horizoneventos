package br.com.erick.horizoneventos.repository;

import br.com.erick.horizoneventos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailContainingIgnoreCase(String email);
}
