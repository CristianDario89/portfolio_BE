package com.abmlAPI.Portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Proyecto {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String nombre;
  private String descripcion; 
  private String img;
  private String start;
  private String end;

    public Proyecto() {
    }

    public Proyecto(Long id, String nombre, String descripcion, String img, String start, String end) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.start = start;
        this.end = end;
    }
  
  
}
