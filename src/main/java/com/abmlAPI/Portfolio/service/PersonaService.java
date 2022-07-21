package com.abmlAPI.Portfolio.service;
 
import com.abmlAPI.Portfolio.model.Persona;
import com.abmlAPI.Portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    
public class PersonaService implements IPersonaService{
    @Autowired 
    public PersonaRepository persRepo;//para q me lea los campos y trabajar sobre ellos

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listapersona  =  persRepo.findAll();
        return listapersona;
    }

    @Override
    public void savePersona(Persona per) {
       persRepo.save(per);
    }

    @Override
    public void deletePersona(Long id) {
          persRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
      Persona persona = persRepo.findById(id).orElse(null);
        return persona;
    }
}
