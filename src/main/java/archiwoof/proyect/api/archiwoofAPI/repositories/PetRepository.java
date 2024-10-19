package archiwoof.proyect.api.archiwoofAPI.repositories;

import archiwoof.proyect.api.archiwoofAPI.entities.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
