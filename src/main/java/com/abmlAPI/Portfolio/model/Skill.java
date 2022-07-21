package com.abmlAPI.Portfolio.model;
 import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity

public class Skill {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String skill;
  private String img;  

    public Skill() {
    }

    public Skill(Long id, String skill, String img) {
        this.id = id;
        this.skill = skill;
        this.img = img;
    }
  
  
}
