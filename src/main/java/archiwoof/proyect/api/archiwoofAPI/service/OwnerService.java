package archiwoof.proyect.api.archiwoofAPI.service;

import archiwoof.proyect.api.archiwoofAPI.entities.Owner;
import archiwoof.proyect.api.archiwoofAPI.entities.Pet;
import archiwoof.proyect.api.archiwoofAPI.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public Owner createOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public Owner findOwner(Long id){
        return ownerRepository.findById(id).get();
    }

    public List<Owner> findAllOwners(){
        return (List<Owner>) ownerRepository.findAll();
    }

    public List<Pet> getPets(Long id){
        Owner owner = ownerRepository.findById(id).orElseThrow(()-> new RuntimeException("Owner not found"));

        return owner.getPets();
    }


}
