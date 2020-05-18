package Telematyka.Projekt.Service;

import Telematyka.Projekt.Repository.BadanieRepository;
import Telematyka.Projekt.model.entities.Badanie;
import Telematyka.Projekt.model.entities.Czas;
import Telematyka.Projekt.Repository.CzasRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CzasService {
    private CzasRepository repository;

    public List<Czas> findAll() {

        return (List<Czas>) repository.findAll();
    }

    public List<Czas> findById (Long id_badania) {
        return (List<Czas>) repository.findById();
    }
    public void deleteById(Long id_badania) {
        CzasRepository.remove(id_badania);
    }

}
