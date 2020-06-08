package Telematyka.Projekt.controller;
import Telematyka.Projekt.Service.PacjentService;
import Telematyka.Projekt.model.entities.Pacjent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class PacjentController {
    @Autowired
    PacjentService pacjentService;

    @GetMapping("/pacjenci")
    public ResponseEntity<List<Pacjent>> getAllPacjents(){
        List<Pacjent> pacjenci = new ArrayList<>();

        try{
            pacjentService.findAll().forEach(pacjenci::add);
            if (pacjenci.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pacjenci, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pacjenci/id_pacjenta={id_pacjenta}")
    public ResponseEntity<Pacjent> getPacjentById(@PathVariable("id_pacjenta") Long id_pacjenta) {
        Pacjent pacjentData = pacjentService.findById(id_pacjenta);
        if(null != pacjentData){
            return new ResponseEntity<>(pacjentData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/pacjenci")
    public ResponseEntity<Pacjent> addPacjent(@RequestBody Pacjent pacjent) {
        try {
            Pacjent pacjentCreated = pacjentService.addPacjent(pacjent);
            return new ResponseEntity<>(pacjentCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PutMapping("/pacjenci")

    public ResponseEntity<Pacjent> updatePacjent(@RequestBody Pacjent pacjent) {
        try {
            return new ResponseEntity<>(pacjentService.updatePacjent(pacjent), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pacjenci/id_pacjenta={id_pacjenta}")
    public ResponseEntity<HttpStatus> deletePacjent(@PathVariable("id_pacjenta") Long id_pacjenta) {
        try {
            boolean result = pacjentService.deletePacjent(id_pacjenta);
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



