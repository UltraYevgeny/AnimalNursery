package services;

import animals.Animals;
import animals.animal_species.*;

public class AnimalClassIdentifier {

    public static Animals animalSpecies(String animalSpecies){

        if (animalSpecies.toLowerCase().equals("camel")){return new Camel();}
        else if (animalSpecies.toLowerCase().equals("donkey")){return new Donkey();}
        else if (animalSpecies.toLowerCase().equals("horse")){return new Horse();}
        else if (animalSpecies.toLowerCase().equals("cat")){return new Cat();}
        else if (animalSpecies.toLowerCase().equals("dog")){return new Dog();}
        else if (animalSpecies.toLowerCase().equals("hamster")){return new Hamster();}

        return null;
    }
}
