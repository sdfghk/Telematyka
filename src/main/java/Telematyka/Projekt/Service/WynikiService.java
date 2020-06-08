package Telematyka.Projekt.Service;


import Telematyka.Projekt.model.entities.Wyniki;
import Telematyka.Projekt.Repository.WynikiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WynikiService {
    @Autowired
    private WynikiRepository repository;

        public List<Wyniki> findAll() {

            return (List<Wyniki>) repository.findAll();
        }

        public Wyniki findById (Long id_wyniku) {
            return  repository.findById(id_wyniku).get();
        }
        public void deleteById(Long id_wyniku) {
            repository.deleteById(id_wyniku);
        }
        public boolean Wynikwbazie (Long id_wyniku) {
            if(repository.existsById(id_wyniku))
            {return true;}
            return false;
        }
    public Wyniki addWynik(Wyniki wyniki) {
        try {
            return
                    repository.save(wyniki);
        } catch (Exception e) {
            return null;
        }
    }

    public Wyniki updateWynik(Wyniki wyniki) {
        try {
            Wyniki oldWynik = repository.findById(wyniki.getId_wyniku()).get();
            if (null != wyniki.getId_p()) {
                oldWynik.setId_p(wyniki.getId_p());
            }
            if (null != wyniki.getId_b()) {
                oldWynik.setId_b(wyniki.getId_b());
            }
            if (null != wyniki.getId_l()) {
                oldWynik.setId_l(wyniki.getId_l());
            }
            if (null != wyniki.getId_c()) {
                oldWynik.setId_c(wyniki.getId_c());
            }

            return repository.save(oldWynik);

        } catch (Exception e) {
            return null;
        }
    }
    public boolean deleteWynik(long id_wyniku) {
        try{
            repository.deleteById(id_wyniku);
        }
        catch (Exception e){
            return false;
        }

        return true;
    }

    }
