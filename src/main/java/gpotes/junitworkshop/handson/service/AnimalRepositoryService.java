package gpotes.junitworkshop.handson.service;

import gpotes.junitworkshop.handson.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalRepositoryService implements IAnimalRepositoryService {
    private final AnimalRepository animalPersistence;

    /**
     * Service constructor
     *
     * @param animalPersistence the persistence data access, injected by spring
     */
    @Autowired
    public AnimalRepositoryService(final AnimalRepository animalPersistence) {
        this.animalPersistence = animalPersistence;
    }

    @Override
    public List<Animal> getAll() {
        return animalPersistence.findAll();
    }

    @Override
    public Animal getOne(final String animalId) {
        return animalPersistence.findOne(animalId);
    }

    @Override
    public Animal create(final Animal entity) {
        return animalPersistence.save(entity);
    }

    @Override
    public Animal update(final Animal entity) {
        return animalPersistence.save(entity);
    }

    @Override
    public void delete(final Animal entity) {
        animalPersistence.delete(entity);
    }
}
