package Telematyka.Projekt.Service;

import Telematyka.Projekt.Repository.LekarzRepository;
import Telematyka.Projekt.Repository.PacjentRepository;
import Telematyka.Projekt.model.entities.Pacjent;
import Telematyka.Projekt.model.entities.Wyniki;
import Telematyka.Projekt.Repository.WynikiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WynikiService {
    private WynikiRepository repository;

    public List<Wyniki> findAll() {

        return (List<Wyniki>) repository.findAll();
    }

    public List<Wyniki> findById (Long id_wyniku) {
        return (List<Wyniki>) repository.findById();
    }
    public void deleteById(Long id_wyniku) {
        WynikiRepository.remove(id_wyniku);
    }
    public boolean Wynikwbazie (Long id_wyniku) {
        if(WynikiRepository.existsById())
        {return true;}
        return false;
    }
}
