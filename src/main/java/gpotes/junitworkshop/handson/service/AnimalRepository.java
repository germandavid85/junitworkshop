package gpotes.junitworkshop.handson.service;

import gpotes.junitworkshop.handson.entity.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalRepository extends MongoRepository<Animal, String> {
}
