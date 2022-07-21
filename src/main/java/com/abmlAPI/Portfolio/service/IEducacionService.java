package com.abmlAPI.Portfolio.service;
 
import com.abmlAPI.Portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> getEducacion();
    
    public void saveEducacion(Educacion edu);
    
    public Educacion saveEducacion2(Educacion edu);
    
    public void deleteEducacion(Long id);
       
    public Educacion findEducacion(Long id);    
 
  
}
