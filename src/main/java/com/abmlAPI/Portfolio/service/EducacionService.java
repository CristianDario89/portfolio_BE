package com.abmlAPI.Portfolio.service;
 
import com.abmlAPI.Portfolio.model.Educacion; 
import com.abmlAPI.Portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
@Autowired 
    public EducacionRepository eduRepo;

    @Override
    public List<Educacion> getEducacion() {
      List<Educacion> listaeducacion  =  eduRepo.findAll();
        return listaeducacion;  
    }

    @Override
    public void saveEducacion(Educacion edu) {
        eduRepo.save(edu);    
    }

    @Override
    public void deleteEducacion(Long id) {
       eduRepo.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion educacion = eduRepo.findById(id).orElse(null);
        return educacion;
    }

    @Override
    public Educacion saveEducacion2(Educacion edu) {
        return  eduRepo.save(edu);  
    }
 
    
}
