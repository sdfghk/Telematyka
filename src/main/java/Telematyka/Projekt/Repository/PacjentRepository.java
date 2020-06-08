package Telematyka.Projekt.Repository;

import Telematyka.Projekt.model.entities.Pacjent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PacjentRepository extends CrudRepository<Pacjent, Long> {
    // boolean existsById_pacjenta(Long id_pacjenta);
    //  static void remove(Long id_pacjenta) {
    //}
    //Object findById_pacjenta();
}
