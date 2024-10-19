package archiwoof.proyect.api.archiwoofAPI.controllers;

import archiwoof.proyect.api.archiwoofAPI.entities.Owner;
import archiwoof.proyect.api.archiwoofAPI.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/create")
    public ResponseEntity createOwner(@RequestBody Owner owner){
        return ResponseEntity.ok(ownerService.createOwner(owner));
    }

    @GetMapping("/{id}")
    public ResponseEntity findOwner(@PathVariable Long id){
        return ResponseEntity.ok(ownerService.findOwner(id));
    }

    @GetMapping("/all")
    public ResponseEntity findAllOwners(){
        return ResponseEntity.ok(ownerService.findAllOwners());
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity findpets(@PathVariable Long id){
        return ResponseEntity.ok(ownerService.getPets(id));
    }



}
