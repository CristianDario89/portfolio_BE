package com.abmlAPI.Portfolio.controller;
  
import com.abmlAPI.Portfolio.model.Proyecto;
import com.abmlAPI.Portfolio.service.IProyectoService;
import java.util.List;
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
public class ProyectoController {
     @Autowired
     private IProyectoService proyServ;
      
     @PostMapping("/proyecto/crear")
    public String agregarProyecto(@RequestBody Proyecto proy){
       proyServ.saveProyecto(proy);
       return "proyecto creada correctamente";
    }
    
    
    @GetMapping("/proyecto/traer")
    @ResponseBody
    public List<Proyecto> verProyecto(){
         return proyServ.getProyecto();
    }
    
    @DeleteMapping("/proyecto/borrar/{id}")
    public String borrarProyecto(@PathVariable Long id){
       proyServ.deleteProyecto(id);
        return "proyecto borrada correctamente";
    }
    
      
    @GetMapping("/proyecto/traer/perfil")
    @ResponseBody
    public Proyecto buscarProyecto(){
         return proyServ.findProyecto((long)2);
    }
    
     @GetMapping("/proyecto/{id}")
	public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id){
			Proyecto proyecto = proyServ.findProyecto(id);
					        /*    .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));*/
			 return ResponseEntity.ok(proyecto); 
	 } 
	
        //este metodo sirve para actualizar empleado
	@PutMapping("/proyecto/actualizar/{id}")
	public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id,@RequestBody Proyecto detallesProyecto){
		Proyecto proyecto = proyServ.findProyecto(id);
				         /*   .orElseThrow(() -> new ResourceNotFoundException("No existe el Educacion con el ID : " + id));*/
		
		proyecto.setNombre(detallesProyecto.getNombre());
		proyecto.setDescripcion(detallesProyecto.getDescripcion());
		proyecto.setImg(detallesProyecto.getImg());
                proyecto.setStart(detallesProyecto.getStart());
		proyecto.setEnd(detallesProyecto.getEnd());
		
		Proyecto ProyectoActualizado =  proyServ.saveProyecto2(proyecto);
		return ResponseEntity.ok(ProyectoActualizado);
    }
}
