package Telematyka.Projekt.Service;
import Telematyka.Projekt.model.entities.Badanie;
import Telematyka.Projekt.Repository.BadanieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

@Service

public class BadanieService {
    @Autowired
    private BadanieRepository repository;

    public List<Badanie> findAll() {

        return (List<Badanie>) repository.findAll();
    }

    public Badanie findById (Long id_badania) {
        return  repository.findById(id_badania).get();
    }
    public void deleteById(Long id_badania) {
        repository.deleteById(id_badania);
    }
    public Badanie addBadanie(Badanie badanie) {
        try {
            return
                    repository.save(badanie);
        } catch (Exception e) {
            return null;
        }
    }

    public Badanie updateBadanie(Badanie badanie) {
        try {
            Badanie oldBadanie = repository.findById(badanie.getId_badania()).get();
            if (null != badanie.getRodzaj_badania()) {
                oldBadanie.setRodzaj_badania(badanie.getRodzaj_badania());
            }
            return repository.save(oldBadanie);

        } catch (Exception e) {
            return null;
        }
    }
    public boolean deleteBadanie(long id_badania) {
        try{
            repository.deleteById(id_badania);
        }
        catch (Exception e){
            return false;
        }

        return true;
    }

}
