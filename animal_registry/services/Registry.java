package services;

import animals.Animals;
import animals.animal_species.*;
import animals.animals_types.PackAnimals;
import animals.animals_types.Pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @apiNote класс реестр, хранит в себе списки домашних и вьючных животных
 */
public class Registry {
    private List<Pets> petsList = new ArrayList<>();
    private List<PackAnimals> packAnimalsList = new ArrayList<>();

    /**
     * @apiNote Метод определяет к какому типу животного принадлежит полученный параметр
     * и после этого помещает животное в соответствующий список
     * @param animal тип данных Animals
     */
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
