package gpotes.junitworkshop.handson.entity;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String animalId;
    private String name;
    private List<Breed> breeds = new ArrayList<>();

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Breed> getBreeds() {
        return new ArrayList<>(breeds);
    }

    public void setBreeds(List<Breed> breeds) {
        this.breeds.clear();
        this.breeds.addAll(breeds);
    }
}
