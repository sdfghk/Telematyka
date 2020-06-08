package Telematyka.Projekt.controller;
import Telematyka.Projekt.Repository.LekarzRepository;
import Telematyka.Projekt.Service.LekarzService;
import Telematyka.Projekt.model.entities.Lekarz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")

public class LekarzController {
    @Autowired
    LekarzService lekarzService;
    @GetMapping("/lekarze")
    public ResponseEntity<List<Lekarz>> getAllLekarze(){
        List<Lekarz> lekarze = new ArrayList<>();

        try{
            lekarzService.findAll().forEach(lekarze::add);
            if (lekarze.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lekarze, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/lekarze/id_lekarza={id_lekarza}")
    public ResponseEntity<Lekarz> getLekarzById(@PathVariable("id_lekarza") Long id_lekarza) {
        Lekarz lekarzData = lekarzService.findById(id_lekarza);
        if(null != lekarzData){
            return new ResponseEntity<>(lekarzData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/lekarze")
    public ResponseEntity<Lekarz> addLekarz(@RequestBody Lekarz lekarz) {
        try {
            Lekarz lekarzCreated = lekarzService.addLekarz(lekarz);
            return new ResponseEntity<>(lekarzCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PutMapping("/lekarze")

    public ResponseEntity<Lekarz> updateLekarz(@RequestBody Lekarz lekarz) {
        try {
            return new ResponseEntity<>(lekarzService.updateLekarz(lekarz), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/lekarze/id_lekarza={id_lekarza}")
    public ResponseEntity<HttpStatus> deleteLekarz(@PathVariable("id_lekarza") Long id_lekarza) {
        try {
            boolean result = lekarzService.deleteLekarz(id_lekarza);
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
