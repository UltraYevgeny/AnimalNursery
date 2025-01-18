package services;

import animals.Animals;
import animals.animal_species.Camel;
import animals.animals_types.PackAnimals;
import view.Menu;
import view.Output;

import java.lang.reflect.Field;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// памятка:  java.sql.Date.valueOf("2000-03-18")

public class Core {
    final private static Menu menu = new Menu();

    public static void run(List<Animals> testList) {
        Registry registry = new Registry();

        // заносим тестовый список в экземпляр registry
        for (int i = 0; i < testList.size(); i++) {
            registry.addAnimal(testList.get(i));
        }


        registry = startMenu(registry);

        System.out.println("\nВыход из реестра выполнен.");

    }

    private static Registry startMenu(Registry registry){
        boolean exitProgramm = false;

        while (exitProgramm == false) {

            Date dob;
            int numberMenu = menu.startMenu();
            Animals newAnimal;

            switch (numberMenu) {

                case 1:
                    // вызов меню добавления животного и помещение животного в список
                    newAnimal = menu.createAnimal();
                    //registry.addAnimal(menu.createAnimal());



                    registry.addAnimal(newAnimal);

                    break;

                case 2:
                    // переход в метод animalСommands класса Core, где меню работы с командами животных
                    animalСommands(registry);
                    break;

                case 3:
                    // вывод животных по дате рождения
                    List<Animals> tempListAllAnimals = new ArrayList<>();
                    tempListAllAnimals.addAll(registry.getPetsList());
                    tempListAllAnimals.addAll(registry.getPackAnimalsList());
                    dob = menu.enterAnimalDob();
                    int flag = 0;
                    for (int i = 0; i < tempListAllAnimals.size(); i++) {
                        if (dob.equals(tempListAllAnimals.get(i).getBirthDate())){
                            System.out.println(tempListAllAnimals.get(i));
                            flag++;
                        }
                    }
                    if (flag == 0) System.out.println("Нет животных с такой датой рождения");

                    break;

                case 4:
                    exitProgramm = true;
                    break;

            }
        }

        return registry;

    }

    private static Registry animalСommands(Registry registry){
        boolean exitProgramm = false;

        while (exitProgramm == false){
            int numberId;
            int numberMenu = menu.animalСommands();

        switch (numberMenu) {
            case 1:
                // вывод животных обоих списков
                Output.outputAnimals(registry);
                break;

            case 2:
                // просмотр комманд одного животного

                numberId = menu.enterAnimalId();
                // вывод команд выбранного животного
                if (numberId < 200) {
                    for (int i = 0; i < registry.getPetsList().size(); i++) {
                        if (registry.getPetsList().get(i).getId() == numberId) {
                            Output.outputCommandsOneAnimal(registry.getPetsList().get(i));
                        }
                    }

                } else if (numberId > 200) {
                    for (int i = 0; i < registry.getPackAnimalsList().size(); i++) {
                        if (registry.getPackAnimalsList().get(i).getId() == numberId) {
                            Output.outputCommandsOneAnimal(registry.getPackAnimalsList().get(i));;
                        }
                    }
                }
                break;

            case 3:
                // ввод новых команд животного
                numberId = menu.enterAnimalId();

                List<String> tempCommands = new ArrayList<>();

                if (numberId < 200) {
                    for (int i = 0; i < registry.getPetsList().size(); i++) {
                        if (registry.getPetsList().get(i).getId() == numberId) {
                            tempCommands.addAll(registry.getPetsList().get(i).getCommands());
                            tempCommands.addAll(List.of(menu.changeСommands()));
                            registry.getPetsList().get(i).setCommands(tempCommands);
                        }
                    }

                } else if (numberId > 200) {
                    for (int i = 0; i < registry.getPackAnimalsList().size(); i++) {
                        if (registry.getPackAnimalsList().get(i).getId() == numberId) {
                            tempCommands.addAll(registry.getPackAnimalsList().get(i).getCommands());
                            tempCommands.addAll(List.of(menu.changeСommands()));
                            registry.getPackAnimalsList().get(i).setCommands(tempCommands);
                        }
                    }
                }

                break;

            case 4:
                exitProgramm = true;
                break;
            }
        }

        return registry;
    }



}
