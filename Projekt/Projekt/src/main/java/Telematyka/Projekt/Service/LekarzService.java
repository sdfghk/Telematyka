package Telematyka.Projekt.Service;

import Telematyka.Projekt.Repository.BadanieRepository;
import Telematyka.Projekt.model.entities.Badanie;
import Telematyka.Projekt.model.entities.Lekarz;
import Telematyka.Projekt.Repository.LekarzRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LekarzService {
    private LekarzRepository repository;

    public List<Lekarz> findAll() {

        return (List<Lekarz>) repository.findAll();
    }

    public List<Lekarz> findById (Long id_lekarza) {
        return (List<Lekarz>) repository.findById();
    }
    public void deleteById(Long id_lekarza) {
        LekarzRepository.remove(id_lekarza);
    }
    public boolean Lekarzwbazie (Long id_lekarza) {
        if(LekarzRepository.existsById())
        {return true;}
        return false;
    }

}


