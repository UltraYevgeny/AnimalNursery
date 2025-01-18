package view;

import animals.Animals;
import services.Registry;

public class Output {

    public static void outputAnimals(Registry registry){

        System.out.println("домашние животные: ");
        for (int i = 0; i < registry.getPetsList().size(); i++) {
            System.out.println(registry.getPetsList().get(i));
        }

        System.out.println("вьючные животные: ");
        for (int i = 0; i < registry.getPackAnimalsList().size(); i++) {
            System.out.println(registry.getPackAnimalsList().get(i));
        }

    }


    static public void outputCommandsOneAnimal(Animals animal){
        System.out.println("\nСписок команд выбранного животного:");
        System.out.println(animal.getCommands());
    }

}
