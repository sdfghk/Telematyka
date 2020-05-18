package Telematyka.Projekt.Service;

import Telematyka.Projekt.Repository.LekarzRepository;
import Telematyka.Projekt.model.entities.Lekarz;
import Telematyka.Projekt.model.entities.Pacjent;
import Telematyka.Projekt.Repository.PacjentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacjentService {
    private PacjentRepository repository;

    public List<Pacjent> findAll() {

        return (List<Pacjent>) repository.findAll();
    }

    public List<Pacjent> findById (Long id_pacjenta) {
        return (List<Pacjent>) repository.findById();
    }
    public void deleteById(Long id_pacjenta) {
        PacjentRepository.remove(id_pacjenta);
    }
    public boolean Pacjentwbazie (Long id_pacjenta) {
        if(PacjentRepository.existsById())
        {return true;}
        return false;
    }
}
