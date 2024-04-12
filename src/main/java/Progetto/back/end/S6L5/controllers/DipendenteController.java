package Progetto.back.end.S6L5.controllers;
import Progetto.back.end.S6L5.entities.Dipendente;
import Progetto.back.end.S6L5.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendentiService;

    @GetMapping
    private List<Dipendente> getAllDipendenti() {
       return this.dipendentiService.getDipendentiList();
    }
    @PostMapping
    private Dipendente saveDipendenti(@RequestBody Dipendente body) {
        return this.dipendentiService.saveDipendente(body);
    }
    @GetMapping("/{dipendenteId}")
    private Dipendente findDipendenteById(@PathVariable long dipendenteId) {
        return this.dipendentiService.findById(dipendenteId);
    }
    @PutMapping("/{dipendenteId}")
    private Dipendente findDipendenteByIdAndUpdate(@PathVariable long dipendenteId, @RequestBody Dipendente body) {
        return this.dipendentiService.findByIdAndUpdate(dipendenteId, body);
    }
    @DeleteMapping("/{dipendenteId}")
    private void findDipendenteByIdAndDelete(@PathVariable long dipendenteId) {
        this.dipendentiService.findByIdAndDelete(dipendenteId);
    }


}
