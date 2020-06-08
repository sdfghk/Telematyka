package Telematyka.Projekt.controller;
import Telematyka.Projekt.Service.BadanieService;
import Telematyka.Projekt.model.entities.Badanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")

public class BadanieController {
    @Autowired
    BadanieService badanieService;
    @GetMapping("/badania")
    public ResponseEntity<List<Badanie>> getAllBadania(){
        List<Badanie> badania = new ArrayList<>();

        try{
            badanieService.findAll().forEach(badania::add);
            if (badania.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(badania, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/badania/id_badania={id_badania}")
    public ResponseEntity<Badanie> getBadanieById(@PathVariable("id_badania") Long id_badania) {
       Badanie badanieData = badanieService.findById(id_badania);
        if(null != badanieData){
            return new ResponseEntity<>(badanieData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/badania")
    public ResponseEntity<Badanie> addBadanie(@RequestBody Badanie badanie) {
        try {
            Badanie badanieCreated = badanieService.addBadanie(badanie);
            return new ResponseEntity<>(badanieCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PutMapping("/badania")

    public ResponseEntity<Badanie> updateBadanie(@RequestBody Badanie badanie) {
        try {
            return new ResponseEntity<>(badanieService.updateBadanie(badanie), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/badania/id_badania={id_badania}")
    public ResponseEntity<HttpStatus> deleteBadanie(@PathVariable("id_badania") Long id_badania) {
        try {
            boolean result = badanieService.deleteBadanie(id_badania);
            if(result){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
            else {
                throw new Exception();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
