package com.abmlAPI.Portfolio.service;
 
import com.abmlAPI.Portfolio.model.Skill;
import java.util.List;

public interface ISkillService {
    public List<Skill> getSkill();
    
    public void saveSkill(Skill pro);
    
    public Skill saveSkill2(Skill proy);
    
    public void deleteSkill(Long id);
       
    public Skill findSkill(Long id);  
}
