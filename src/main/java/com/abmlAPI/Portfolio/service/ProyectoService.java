package com.abmlAPI.Portfolio.service;

import com.abmlAPI.Portfolio.model.Proyecto; 
import com.abmlAPI.Portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
@Autowired 
    public ProyectoRepository proyRepo;
    @Override
    
    public List<Proyecto> getProyecto() {
      List<Proyecto> listaproyecto  =  proyRepo.findAll();
        return listaproyecto;  
    }

    @Override
    public void saveProyecto(Proyecto proy) {
        proyRepo.save(proy);    
    }

    @Override
    public void deleteProyecto(Long id) {
       proyRepo.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        Proyecto proyecto = proyRepo.findById(id).orElse(null);
        return proyecto;
    }

    @Override
    public Proyecto saveProyecto2(Proyecto proy) {
     return  proyRepo.save(proy);
    }
    
}