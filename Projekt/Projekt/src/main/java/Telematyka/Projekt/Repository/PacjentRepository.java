package Telematyka.Projekt.Repository;

import Telematyka.Projekt.model.entities.Pacjent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PacjentRepository extends CrudRepository<Pacjent, Long> {
    static boolean existsById() {
        if(PacjentRepository.existsById())
        {return true;}
        return false;
    }

    static void remove(Long id_pacjenta) {
    }

    Object findById();
}
