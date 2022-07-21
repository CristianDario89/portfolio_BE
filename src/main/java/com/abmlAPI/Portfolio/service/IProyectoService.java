package com.abmlAPI.Portfolio.service;

import com.abmlAPI.Portfolio.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    public List<Proyecto> getProyecto();
    
    public void saveProyecto(Proyecto proy);
    
    public Proyecto saveProyecto2(Proyecto proy);
    
    public void deleteProyecto(Long id);
       
    public Proyecto findProyecto(Long id);    
}
