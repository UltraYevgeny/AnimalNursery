package services;

import animals.Animals;
import animals.animal_species.*;
import animals.animals_types.PackAnimals;
import animals.animals_types.Pets;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    private List<Pets> petsList = new ArrayList<>();
    private List<PackAnimals> packAnimalsList = new ArrayList<>();

    void addAnimal(Animals animal){

        if (animal.getClass() == Camel.class){
            packAnimalsList.add((Camel) animal);
        }
        else if (animal.getClass() == Donkey.class){
            packAnimalsList.add((Donkey) animal);
        }
        else if (animal.getClass() == Horse.class){
            packAnimalsList.add((Horse) animal);
        }
        else if (animal.getClass() == Cat.class){
            petsList.add((Cat) animal);
        }
        else if (animal.getClass() == Dog.class){
            petsList.add((Dog) animal);
        }
        else if (animal.getClass() == Hamster.class){
            petsList.add((Hamster) animal);
        }

    }

    public List<Pets> getPetsList() {
        return petsList;
    }

    public List<PackAnimals> getPackAnimalsList() {
        return packAnimalsList;
    }
}
