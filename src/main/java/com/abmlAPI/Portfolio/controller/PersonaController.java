package com.abmlAPI.Portfolio.controller;
 
import com.abmlAPI.Portfolio.model.Persona;
import com.abmlAPI.Portfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class PersonaController {
    
     @Autowired
     private IPersonaService persoServ;
     
    @PostMapping("/personas/crear")
    public String agregarPersona(@RequestBody Persona pers){
       persoServ.savePersona(pers);
       return "persona creada correctamente";
    }
    
    
    @GetMapping("/personas/traer")
    @ResponseBody
    public List<Persona> verPersonas(){
         return persoServ.getPersonas();
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String borrarPersona(@PathVariable Long id){
       persoServ.deletePersona(id);
        return "persona borrada correctamente";
    }
    
      
    @GetMapping("/personas/traer/perfil")
    @ResponseBody
    public Persona buscarPersona(){
         return persoServ.findPersona((long)2);
    }
    
    
   /* @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre")String nNombre,
                               @RequestParam("apellido")String nApellido,
                               @RequestParam("img")String nImg,
                               ){
        Persona persona = IPersonaService.findPersona(id);
        persona.setNombre(nNombre);
        persona.setApellido(nApellido);
        persona.setImg(nImg);
        persoServ.savePersona(persona);
       
        return persona;
    }*/
     
}
