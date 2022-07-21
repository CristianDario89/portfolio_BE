package com.abmlAPI.Portfolio.service;
 
import com.abmlAPI.Portfolio.model.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abmlAPI.Portfolio.repository.SkillRepository;

@Service    
public class SkillService implements ISkillService{
  @Autowired 
    public SkillRepository skillServ; 

    @Override
    public List<Skill> getSkill() {
       List<Skill> listaskills  =  skillServ.findAll();
        return listaskills;
    }

    @Override
    public void saveSkill(Skill ski) {
        skillServ.save(ski);
    }

    @Override
    public void deleteSkill(Long id) {
        skillServ.deleteById(id);  
    }

    @Override
    public Skill findSkill(Long id) {
     Skill skill = skillServ.findById(id).orElse(null);
        return skill; 
    }

    @Override
    public Skill saveSkill2(Skill proy) {
    return  skillServ.save(proy);
    }
    
}
