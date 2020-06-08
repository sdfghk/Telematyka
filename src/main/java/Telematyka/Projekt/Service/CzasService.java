package Telematyka.Projekt.Service;

import Telematyka.Projekt.model.entities.Czas;
import Telematyka.Projekt.Repository.CzasRepository;
import java.util.List;

import Telematyka.Projekt.model.entities.Pacjent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CzasService {
    @Autowired
    private CzasRepository repository;

    public List<Czas> findAll() {

        return (List<Czas>) repository.findAll();
    }

    public Czas findById (Long id_czas) {
        return  repository.findById(id_czas).get();
    }
    public void deleteById(Long id_czas) {
        repository.deleteById(id_czas);
    }

    public Czas addCzas(Czas czas) {
        try {
            return
                    repository.save(czas);
        } catch (Exception e) {
            return null;
        }
    }

    public Czas updateCzas(Czas czas) {
        try {
            Czas oldCzas = repository.findById(czas.getId_czas()).get();
            if (null != czas.getTermin()) {
                oldCzas.setTermin(czas.getTermin());
            }

            return repository.save(oldCzas);

        } catch (Exception e) {
            return null;
        }
    }
    public boolean deleteCzas(long id_czas) {
        try{
            repository.deleteById(id_czas);
        }
        catch (Exception e){
            return false;
        }

        return true;
    }
}
