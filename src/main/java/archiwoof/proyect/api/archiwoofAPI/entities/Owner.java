package archiwoof.proyect.api.archiwoofAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String name;
    private String lastname;
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets;

    //Gestion de mascotas

    public void addPet(Pet pet){
        pets.add(pet);
        pet.setOwner(this);
    }
    public void removePet(Pet pet){
        pets.remove(pet);
        pet.setOwner(null);
    }

}
