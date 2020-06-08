package Telematyka.Projekt.Service;


import Telematyka.Projekt.model.entities.Wyniki;
import Telematyka.Projekt.Repository.WynikiRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class WynikiService {

    public WynikiService(Path fileStorageLocation) {
        this.fileStorageLocation = fileStorageLocation;
    }
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
    private final Path fileStorageLocation;
    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }



    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }

}
