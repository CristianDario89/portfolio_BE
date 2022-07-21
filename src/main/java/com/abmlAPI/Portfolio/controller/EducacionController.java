package com.abmlAPI.Portfolio.controller;

import com.abmlAPI.Portfolio.excepciones.ResourceNotFoundException;
import com.abmlAPI.Portfolio.model.Educacion;
import com.abmlAPI.Portfolio.service.IEducacionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
 @RequestMapping("/api")
public class EducacionController {
     @Autowired
     private IEducacionService eduServ;
      
     @PostMapping("/educacion/crear")
    public String agregarEducacion(@RequestBody Educacion edu){
       eduServ.saveEducacion(edu);
       return "persona creada correctamente";
    }
    
    
    @GetMapping("/educacion/traer")
    @ResponseBody
    public List<Educacion> verEducacion(){
         return eduServ.getEducacion();
    }
    
    @DeleteMapping("/educacion/borrar/{id}")
    public String borrarEducacion(@PathVariable Long id){
       eduServ.deleteEducacion(id);
        return "persona borrada correctamente";
    }
    
      
    @GetMapping("/educacion/traer/perfil")
    @ResponseBody
    public Educacion buscarEducacion(){
         return eduServ.findEducacion((long)2);
    }
     
	@GetMapping("/educacion/{id}")
	public ResponseEntity<Educacion> obtenerEducacionPorId(@PathVariable Long id){
			Educacion educacion = eduServ.findEducacion(id);
					        /*    .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));*/
			 return ResponseEntity.ok(educacion); 
	 } 
	
        //este metodo sirve para actualizar empleado
	@PutMapping("/educacion/actualizar/{id}")
	public ResponseEntity<Educacion> actualizarEducacion(@PathVariable Long id,@RequestBody Educacion detallesEducacion){
		Educacion educacion = eduServ.findEducacion(id);
				         /*   .orElseThrow(() -> new ResourceNotFoundException("No existe el Educacion con el ID : " + id));*/
		
		educacion.setInstitucion(detallesEducacion.getInstitucion());
		educacion.setTitle(detallesEducacion.getTitle());
		educacion.setImg(detallesEducacion.getImg());
                educacion.setStart(detallesEducacion.getStart());
		educacion.setEnd(detallesEducacion.getEnd());
		
		Educacion educacionActualizado =  eduServ.saveEducacion2(educacion);
		return ResponseEntity.ok(educacionActualizado);
    }
	
       /* @DeleteMapping("/educacion/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarEducacion(@PathVariable Long id){
		Educacion educacion = eduServ.findEducacion(id);
                
		eduServ.deleteEducacion(educacion);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }*/
}
