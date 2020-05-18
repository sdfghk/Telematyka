package Telematyka.Projekt.Repository;

import Telematyka.Projekt.model.entities.Wyniki;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface WynikiRepository extends CrudRepository<Wyniki, Long> {
    static void remove(Long id_wyniku) {
    }

    static boolean existsById() {
        if(WynikiRepository.existsById())
        {return true;}
        return false;
    }

    Object findById();
}
