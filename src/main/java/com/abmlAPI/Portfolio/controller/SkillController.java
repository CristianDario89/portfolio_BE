package com.abmlAPI.Portfolio.controller;
 
import com.abmlAPI.Portfolio.model.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.abmlAPI.Portfolio.service.ISkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class SkillController {
   @Autowired
     private ISkillService skillServ; 
   
    
    @PostMapping("/skill/crear")
    public String agregarProyecto(@RequestBody Skill ski){
       skillServ.saveSkill(ski);
       return "Skill creada correctamente";
    }
    
    
    @GetMapping("/skill/traer")
    @ResponseBody
    public List<Skill> verProyecto(){
         return skillServ.getSkill();
    }
    
    @DeleteMapping("/skill/borrar/{id}")
    public String borrarProyecto(@PathVariable Long id){
       skillServ.deleteSkill(id);
        return "Skill borrada correctamente";
    }
    
      
    @GetMapping("/skill/traer/perfil")
    @ResponseBody
    public Skill buscarProyecto(){
         return skillServ.findSkill((long)2);
    }
    
    @GetMapping("/skill/{id}")
	public ResponseEntity<Skill> obtenerSkillPorId(@PathVariable Long id){
			Skill skill = skillServ.findSkill(id);
					        /*    .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));*/
			 return ResponseEntity.ok(skill); 
	 } 
	
        //este metodo sirve para actualizar empleado
	@PutMapping("/skill/actualizar/{id}")
	public ResponseEntity<Skill> actualizarSkill(@PathVariable Long id,@RequestBody Skill detallesSkill){
		Skill skill = skillServ.findSkill(id);
				         /*   .orElseThrow(() -> new ResourceNotFoundException("No existe el Educacion con el ID : " + id));*/
		
		skill.setSkill(detallesSkill.getSkill()); 
		skill.setImg(detallesSkill.getImg()); 
		
		Skill SkillActualizado =  skillServ.saveSkill2(skill);
		return ResponseEntity.ok(SkillActualizado);
    }
    
}
