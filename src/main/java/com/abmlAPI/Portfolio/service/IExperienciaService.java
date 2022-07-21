package com.abmlAPI.Portfolio.service;
 
import com.abmlAPI.Portfolio.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> getExperiencia();
    
    public void saveExperiencia(Experiencia exp);
    
    public Experiencia saveExperiencia2(Experiencia edu);
    
    public void deleteExperiencia(Long id);
       
    public Experiencia findExperiencia(Long id);  
}
