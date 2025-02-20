package Progetto.back.end.S6L5.controllers;
import Progetto.back.end.S6L5.entities.Dipendente;
import Progetto.back.end.S6L5.exceptions.BadRequestException;
import Progetto.back.end.S6L5.payloads.dipendenti.NewDipendenteDTO;
import Progetto.back.end.S6L5.payloads.dipendenti.NewDipendenteResponseDTO;
import Progetto.back.end.S6L5.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendentiService;

    @GetMapping("")
    public Page<Dipendente> getAuthors(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return dipendentiService.getAuthors(page, size, sortBy);
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public NewDipendenteResponseDTO saveDipendente(@RequestBody @Validated NewDipendenteDTO body, BindingResult validation) throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        Dipendente newDipendente = dipendentiService.saveDipendente(body);
        return new NewDipendenteResponseDTO(newDipendente.getId());
    }
    @GetMapping("/{dipendenteId}")
    public Dipendente findById(@PathVariable int authorId) {
        return dipendentiService.findById(authorId);
    }
    @PutMapping("/{dipendenteId}")
    public Dipendente findAndUpdate(@PathVariable int authorId, @RequestBody Dipendente body) {
        return dipendentiService.findByIdAndUpdate(authorId, body);
    }
    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int authorId) {
        dipendentiService.findByIdAndDelete(authorId);
    }


}
