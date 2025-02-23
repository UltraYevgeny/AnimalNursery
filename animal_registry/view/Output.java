package view;

import animals.Animals;
import services.Counter;
import services.Registry;

public class Output {

    public static void outputAnimals(Registry registry){

        System.out.println("\nдомашние животные: ");
        for (int i = 0; i < registry.getPetsList().size(); i++) {
            System.out.println(registry.getPetsList().get(i));
        }

        System.out.println("вьючные животные: ");
        for (int i = 0; i < registry.getPackAnimalsList().size(); i++) {
            System.out.println(registry.getPackAnimalsList().get(i));
        }

    }


    public static void outputCommandsOneAnimal(Animals animal){
        System.out.println("\nСписок команд выбранного животного:");
        System.out.println(animal.getCommands());
    }

    public static void outputCounterAllAnimals(){
        System.out.println("\nОбщее количество животных: " + Counter.getCounter());
    }

}
