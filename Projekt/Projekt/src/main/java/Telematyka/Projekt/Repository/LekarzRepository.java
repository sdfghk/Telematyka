package Telematyka.Projekt.Repository;

import Telematyka.Projekt.model.entities.Lekarz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LekarzRepository extends CrudRepository<Lekarz, Long> {
    static boolean existsById() {
        if(LekarzRepository.existsById())
        {return true;}
        return false;
    }

    static void remove(Long id_lekarza) {
    }

    Object findById();
}
