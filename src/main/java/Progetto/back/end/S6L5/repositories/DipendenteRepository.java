package Progetto.back.end.S6L5.repositories;

import Progetto.back.end.S6L5.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    Optional<Dipendente> findByEmail(String email);
}
