package gpotes.junitworkshop.handson.service;

import gpotes.junitworkshop.handson.entity.Animal;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AnimalRepositoryServiceTest {
    @Mock private AnimalRepository mockAnimalRepository;

    private Animal animalSave = new Animal();

    private IAnimalRepositoryService sut;

    @Before
    public void setup() {
        sut = new AnimalRepositoryService(mockAnimalRepository);
        when(mockAnimalRepository.findAll()).thenReturn(new ArrayList<>());
        when(mockAnimalRepository.findOne("1234")).thenReturn(new Animal());
        when(mockAnimalRepository.save(animalSave)).thenReturn(new Animal());
    }
}
