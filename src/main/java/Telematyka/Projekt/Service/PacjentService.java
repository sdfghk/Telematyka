package Telematyka.Projekt.Service;

import Telematyka.Projekt.model.entities.Pacjent;
import Telematyka.Projekt.Repository.PacjentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacjentService {
    @Autowired
    private PacjentRepository repository;

    public List<Pacjent> findAll() {

        return (List<Pacjent>) repository.findAll();
    }

    public Pacjent findById(Long id_pacjenta) {
        return repository.findById(id_pacjenta).get();
    }

    public void deleteById(Long id_pacjenta) {
        repository.deleteById(id_pacjenta);
    }

    public boolean Pacjentwbazie(Long id_pacjenta) {
        if (repository.existsById(id_pacjenta)) {
            return true;
        }
        return false;
    }

    public Pacjent addPacjent(Pacjent pacjent) {
        try {
            return
                    repository.save(pacjent);
        } catch (Exception e) {
            return null;
        }
    }

    public Pacjent updatePacjent(Pacjent pacjent) {
        try {
            Pacjent oldPacjent = repository.findById(pacjent.getId_pacjenta()).get();
            if (null != pacjent.getImie()) {
                oldPacjent.setImie(pacjent.getImie());
            }
            if (null != pacjent.getNazwisko()) {
                oldPacjent.setNazwisko(pacjent.getNazwisko());
            }
            if (null != pacjent.getPESEL()) {
                oldPacjent.setPESEL(pacjent.getPESEL());
            }
            if (null != pacjent.getAdres()) {
                oldPacjent.setAdres(pacjent.getAdres());
            }
            if (null != pacjent.getKod_pocztowy()) {
                oldPacjent.setKod_pocztowy(pacjent.getKod_pocztowy());
            }
            if (null != pacjent.getMiejscowosc()) {
                oldPacjent.setMiejscowosc(pacjent.getMiejscowosc());
            }
            if (null != pacjent.getNumer_telefonu()) {
                oldPacjent.setNumer_telefonu(pacjent.getNumer_telefonu());
            }

            return repository.save(oldPacjent);

        } catch (Exception e) {
            return null;
        }
    }
    public boolean deletePacjent(long id_pacjenta) {
        try{
            repository.deleteById(id_pacjenta);
        }
        catch (Exception e){
            return false;
        }

        return true;
    }
}
