package com.abmlAPI.Portfolio.repository;
 
import com.abmlAPI.Portfolio.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository <Skill, Long>{
    
}
