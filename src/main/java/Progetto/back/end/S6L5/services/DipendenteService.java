package Progetto.back.end.S6L5.services;

import Progetto.back.end.S6L5.entities.Dipendente;
import Progetto.back.end.S6L5.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class DipendenteService {
    private List<Dipendente> dipendentiList = new ArrayList<>();

    public List<Dipendente> getDipendentiList() {
        return this.dipendentiList;
    }

    public Dipendente saveDipendente(Dipendente body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(1, 1000));
        this.dipendentiList.add(body);
        return body;
    }

    public Dipendente findById(long id) {
        Dipendente found = null;
        for (Dipendente dipendente : this.dipendentiList) {
            if (dipendente.getId() == id) found = dipendente;

        }
        if (found==null)throw new NotFoundException(id);
        else return found;
    }
    public Dipendente findByIdAndUpdate (long id, Dipendente updatedDipendente) {
        Dipendente found =null;
        for(Dipendente dipendente: this.dipendentiList) {
            if (dipendente.getId() == id) {
                found = dipendente;
                found.setUsername(updatedDipendente.getUsername());
                found.setNome(updatedDipendente.getNome());
                found.setCognome(updatedDipendente.getCognome());
                found.setEmail(updatedDipendente.getEmail());
            }

        }
        if (found == null) throw new NotFoundException(id);
        else return found;
    }
    public void findByIdAndDelete(long id) {
        Iterator<Dipendente> iterator = this.dipendentiList.iterator();
        while(iterator.hasNext()){
            Dipendente current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }



    }

}


