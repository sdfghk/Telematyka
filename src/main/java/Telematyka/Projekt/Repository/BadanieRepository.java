package Telematyka.Projekt.Repository;


import Telematyka.Projekt.model.entities.Badanie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BadanieRepository extends CrudRepository<Badanie, Long> {

    //static void remove(Long id_badania) {
    //}
    //Object findById_badania();
}


