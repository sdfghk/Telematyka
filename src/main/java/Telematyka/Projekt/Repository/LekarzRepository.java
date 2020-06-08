package Telematyka.Projekt.Repository;

import Telematyka.Projekt.model.entities.Lekarz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LekarzRepository extends CrudRepository<Lekarz, Long> {
   //boolean existsById_lekarza(Long id_lekarza);
    //static void remove(Long id_lekarza) {
    //}
    //Object findById_lekarza();
}
