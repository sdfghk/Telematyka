package Telematyka.Projekt.controller;
import Telematyka.Projekt.Service.WynikiService;
import Telematyka.Projekt.model.entities.UploadFileResponse;
import Telematyka.Projekt.model.entities.Wyniki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")

public class WynikiController {
    @Autowired
    WynikiService wynikiService;

    @GetMapping("/wyniki")
    public ResponseEntity<List<Wyniki>> getAllWyniki() {
        List<Wyniki> wyniki = new ArrayList<>();

        try {
            wynikiService.findAll().forEach(wyniki::add);
            if (wyniki.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(wyniki, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/wyniki/id_wyniku={id_wyniku}")
    public ResponseEntity<Wyniki> getWynikById(@PathVariable("id_wyniku") Long id_wyniku) {
        Wyniki wynikiData = wynikiService.findById(id_wyniku);
        if (null != wynikiData) {
            return new ResponseEntity<>(wynikiData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/wyniki")
    public ResponseEntity<Wyniki> addWynik(@RequestBody Wyniki wyniki) {
        try {
            Wyniki wynikiCreated = wynikiService.addWynik(wyniki);
            return new ResponseEntity<>(wynikiCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/wyniki")

    public ResponseEntity<Wyniki> updateWynik(@RequestBody Wyniki wyniki) {
        try {
            return new ResponseEntity<>(wynikiService.updateWynik(wyniki), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/wyniki/id_wyniku={id_wyniku}")
    public ResponseEntity<HttpStatus> deleteWynik(@PathVariable("id_wyniku") Long id_wyniku) {
        try {
            boolean result = wynikiService.deleteWynik(id_wyniku);
            if (result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = wynikiService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = wynikiService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Nie udało się ustalić typu pliku");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
