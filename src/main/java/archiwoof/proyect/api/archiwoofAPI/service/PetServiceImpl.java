package archiwoof.proyect.api.archiwoofAPI.service;

import archiwoof.proyect.api.archiwoofAPI.entities.Owner;
import archiwoof.proyect.api.archiwoofAPI.entities.Pet;
import archiwoof.proyect.api.archiwoofAPI.repositories.OwnerRepository;
import archiwoof.proyect.api.archiwoofAPI.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public Pet addPet(Long ownerId, Pet pet){

        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.addPet(pet);
        petRepository.save(pet);
        ownerRepository.save(owner);

        return pet;
    }

    public Pet findPet(Long id){
        return petRepository.findById(id).get();
    }
}
