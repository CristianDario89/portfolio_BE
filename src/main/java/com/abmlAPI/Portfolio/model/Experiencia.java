package com.abmlAPI.Portfolio.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Experiencia {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
  private String empresa;
  private String puesto; 
  private String img;
  private String start;
  private String end;

    public Experiencia() {
    }

    public Experiencia(Long id, String empresa, String puesto, String img, String start, String end) {
        this.id = id;
        this.empresa = empresa;
        this.puesto = puesto;
        this.img = img;
        this.start = start;
        this.end = end;
    }
  
  
}
