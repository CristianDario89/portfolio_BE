package com.abmlAPI.Portfolio.controller;
 
import com.abmlAPI.Portfolio.model.Experiencia;
import com.abmlAPI.Portfolio.service.IExperienciaService;
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
public class ExperienciaController {
   @Autowired
    private IExperienciaService expServ;  
   
    @PostMapping("/experiencia/crear")
    public String agregarExperiencia(@RequestBody Experiencia exp){
       expServ.saveExperiencia(exp);
       return "persona creada correctamente";
    }
    
    
    @GetMapping("/experiencia/traer")
    @ResponseBody
    public List<Experiencia> verExperiencia(){
         return expServ.getExperiencia();
    }
    
    @DeleteMapping("/experiencia/borrar/{id}")
    public String borrarExperiencia(@PathVariable Long id){
       expServ.deleteExperiencia(id);
        return "persona borrada correctamente";
    }
    
      
    @GetMapping("/experiencia/traer/perfil")
    @ResponseBody
    public Experiencia buscarExperiencia(){
         return expServ.findExperiencia((long)2);
    }
    
    @GetMapping("/experiencia/{id}")
	public ResponseEntity<Experiencia> obtenerExperienciaPorId(@PathVariable Long id){
			Experiencia experiencia = expServ.findExperiencia(id);
					        /*    .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));*/
			 return ResponseEntity.ok(experiencia); 
	 } 
	
        //este metodo sirve para actualizar empleado
	@PutMapping("/experiencia/actualizar/{id}")
	public ResponseEntity<Experiencia> actualizarExperiencia(@PathVariable Long id,@RequestBody Experiencia detallesExperiencia){
		Experiencia experiencia = expServ.findExperiencia(id);
				         /*   .orElseThrow(() -> new ResourceNotFoundException("No existe el Educacion con el ID : " + id));*/
		
		experiencia.setEmpresa(detallesExperiencia.getEmpresa());
		experiencia.setPuesto(detallesExperiencia.getPuesto());
		experiencia.setImg(detallesExperiencia.getImg());
                experiencia.setStart(detallesExperiencia.getStart());
		experiencia.setEnd(detallesExperiencia.getEnd());
		
		Experiencia ExperienciaActualizado =  expServ.saveExperiencia2(experiencia);
		return ResponseEntity.ok(ExperienciaActualizado);
    }
}
