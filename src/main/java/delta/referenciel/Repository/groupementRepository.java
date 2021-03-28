package delta.referenciel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import delta.referenciel.Domain.Groupement;

import java.util.Optional;


public interface groupementRepository extends JpaRepository<Groupement, Long>{

    Iterable<Groupement> findBySection(Long id);
}
