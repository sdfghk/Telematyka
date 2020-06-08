package Telematyka.Projekt.Service;

import Telematyka.Projekt.model.entities.Lekarz;
import Telematyka.Projekt.Repository.LekarzRepository;
import java.util.List;

import Telematyka.Projekt.model.entities.Pacjent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LekarzService {
    @Autowired
    private LekarzRepository repository;

    public List<Lekarz> findAll() {

        return (List<Lekarz>) repository.findAll();
    }

    public Lekarz findById (Long id_lekarza) {
        return  repository.findById(id_lekarza).get();
    }
    public void deleteById(Long id_lekarza) {
        repository.deleteById(id_lekarza);
    }
    public boolean Lekarzwbazie (Long id_lekarza) {
        if(repository.existsById(id_lekarza))
        {return true;}
        return false;
    }
    public Lekarz addLekarz(Lekarz lekarz) {
        try {
            return
                    repository.save(lekarz);
        } catch (Exception e) {
            return null;
        }
    }

    public Lekarz updateLekarz(Lekarz lekarz) {
        try {
            Lekarz oldLekarz = repository.findById(lekarz.getId_lekarza()).get();
            if (null != lekarz.getImie()) {
                oldLekarz.setImie(lekarz.getImie());
            }
            if (null != lekarz.getNazwisko()) {
                oldLekarz.setNazwisko(lekarz.getNazwisko());
            }
            if (null != lekarz.getSpecjalizacja()) {
                oldLekarz.setSpecjalizacja(lekarz.getSpecjalizacja());
            }

            return repository.save(oldLekarz);

        } catch (Exception e) {
            return null;
        }
    }
    public boolean deleteLekarz(long id_lekarza) {
        try{
            repository.deleteById(id_lekarza);
        }
        catch (Exception e){
            return false;
        }

        return true;
    }

}


