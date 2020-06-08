package Telematyka.Projekt.Repository;

import Telematyka.Projekt.model.entities.Czas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CzasRepository extends CrudRepository<Czas, Long> {
    //static void remove(Long id_badania) {
    //}
   // Object findById();
}

