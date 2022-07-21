package com.abmlAPI.Portfolio.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Educacion {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String institucion;
  private String title; 
  private String img;
  private String start;
  private String end;

    public Educacion() {
    }

    public Educacion(Long id, String institucion, String title, String img, String start, String end) {
        this.id = id;
        this.institucion = institucion;
        this.title = title;
        this.img = img;
        this.start = start;
        this.end = end;
    }
  
  
}
