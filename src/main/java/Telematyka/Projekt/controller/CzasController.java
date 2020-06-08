package Telematyka.Projekt.controller;
import Telematyka.Projekt.Service.CzasService;
import Telematyka.Projekt.model.entities.Czas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")

public class CzasController {
    @Autowired
    CzasService czasService;
    @GetMapping("/czas")
    public ResponseEntity<List<Czas>> getAllCzas(){
        List<Czas> czas = new ArrayList<>();

        try{
            czasService.findAll().forEach(czas::add);
            if (czas.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(czas, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/czas/id_czas={id_czas}")
    public ResponseEntity<Czas> getCzasById(@PathVariable("id_czas") Long id_czas) {
        Czas czasData = czasService.findById(id_czas);
        if(null != czasData){
            return new ResponseEntity<>(czasData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/czas")
    public ResponseEntity<Czas> addPacjent(@RequestBody Czas czas) {
        try {
            Czas czasCreated = czasService.addCzas(czas);
            return new ResponseEntity<>(czasCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PutMapping("/czas")

    public ResponseEntity<Czas> updateProduct(@RequestBody Czas czas) {
        try {
            return new ResponseEntity<>(czasService.updateCzas(czas), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/czas/id_czas={id_czas}")
    public ResponseEntity<HttpStatus> deleteCzas(@PathVariable("id_czas") Long id_czas) {
        try {
            boolean result = czasService.deleteCzas(id_czas);
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
