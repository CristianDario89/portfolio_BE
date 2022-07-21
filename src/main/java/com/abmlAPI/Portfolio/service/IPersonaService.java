package com.abmlAPI.Portfolio.service;
 
import com.abmlAPI.Portfolio.model.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersonas();
    
    public void savePersona(Persona per);
    
    public void deletePersona(Long id);
       
    public Persona findPersona(Long id);    
}
