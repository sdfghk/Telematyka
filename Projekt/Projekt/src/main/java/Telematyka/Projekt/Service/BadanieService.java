package Telematyka.Projekt.Service;

import Telematyka.Projekt.model.entities.Badanie;
import Telematyka.Projekt.Repository.BadanieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

@Service

public class BadanieService {

    private BadanieRepository repository;

    public List<Badanie> findAll() {

        return (List<Badanie>) repository.findAll();
    }

    public List<Badanie> findById (Long id_badania) {
        return (List<Badanie>) repository.findById();
    }
    public void deleteById(Long id_badania) {
         BadanieRepository.remove(id_badania);
    }


}
