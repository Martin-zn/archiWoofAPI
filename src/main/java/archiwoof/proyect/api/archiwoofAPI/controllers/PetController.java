package archiwoof.proyect.api.archiwoofAPI.controllers;

import archiwoof.proyect.api.archiwoofAPI.entities.Pet;
import archiwoof.proyect.api.archiwoofAPI.service.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetServiceImpl petService;

    @PostMapping("/create/{id}")
    public ResponseEntity createPet(@PathVariable Long id, @RequestBody Pet pet){
        return ResponseEntity.ok(petService.addPet(id, pet));
    }

    @GetMapping("/{id}")
    public ResponseEntity findPet(@PathVariable Long id){
        return ResponseEntity.ok(petService.findPet(id));
    }



}
