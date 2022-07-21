package com.abmlAPI.Portfolio.service;

import com.abmlAPI.Portfolio.model.Experiencia;
import com.abmlAPI.Portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
@Autowired 

public ExperienciaRepository expRepo;

    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> listaexperiencia  =  expRepo.findAll();
        return listaexperiencia; 
    }

    @Override
    public void saveExperiencia(Experiencia exp) {
     expRepo.save(exp);    
    }
     
    @Override
    public void deleteExperiencia(Long id) {
         expRepo.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
          Experiencia experiencia = expRepo.findById(id).orElse(null);
        return experiencia;
    }

    @Override
    public Experiencia saveExperiencia2(Experiencia exp) {
        return  expRepo.save(exp);  
    }
    
}
