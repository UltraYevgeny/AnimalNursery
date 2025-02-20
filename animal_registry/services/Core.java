package services;

import animals.Animals;
import animals.animal_species.Camel;
import animals.animals_types.PackAnimals;
import animals.animals_types.Pets;
import view.Menu;
import view.Output;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.List;

// памятка:  java.sql.Date.valueOf("2000-03-18")

public class Core {
    final private static Menu menu = new Menu();
    final private static Counter counterObject = new Counter();

    public static void run(List<Animals> testList) {
        Registry registry = new Registry();

        // заносим тестовый список в экземпляр registry
        for (int i = 0; i < testList.size(); i++) {
            registry.addAnimal(testList.get(i));
        }
        PackAnimals.setPackAnimalsIdCounter(203);
        Pets.setPetsIdCounter(103);
        Counter.setCounter(6);


        registry = startMenu(registry);

        System.out.println("\nВыход из реестра выполнен.");

    }

    private static Registry startMenu(Registry registry){
        boolean exitProgramm = false;

        while (exitProgramm == false) {

            Date dob = null;
            int numberMenu = menu.startMenu();

            switch (numberMenu) {

                case 1:
                    // вызов меню добавления животного и помещение животного в список
                    try (counterObject){
                        Animals newAnimal = null;
                        try {
                            newAnimal = menu.createAnimal();
                        } catch (Exception e) {
                            System.out.println("\nДанные введены не верно, попробуйте еще раз. (err_1)");
                            break;
                        }

                        if (!newAnimal.getName().isEmpty() &&
                        newAnimal.getBirthDate() != null &&
                        !newAnimal.getCommands().get(0).isEmpty()){

                            if (newAnimal.getClass().getSuperclass() == PackAnimals.class){
                                newAnimal.setId(PackAnimals.getPackAnimalsIdCounter());
                            } else if (newAnimal.getClass().getSuperclass() == Pets.class){
                                newAnimal.setId(Pets.getPetsIdCounter());
                            }
                            registry.addAnimal(newAnimal);
                            counterObject.add();

                        } else System.out.println("\nДанные введены не верно, попробуйте еще раз. (err_2)");
                    } catch (IOException e) {
                        System.out.println("Ресурс остался открыт");
                        throw new RuntimeException(e);
                    }

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
                    try {
                        dob = menu.enterAnimalDob();
                    } catch (IllegalArgumentException e){
                        System.out.println("\nДанные введены не верно, попробуйте еще раз. (err_3)");
                        break;
                    }

                    boolean flag = false;
                    for (int i = 0; i < tempListAllAnimals.size(); i++) {
                        if (dob.equals(tempListAllAnimals.get(i).getBirthDate())){
                            System.out.println(tempListAllAnimals.get(i));
                            flag = true;
                        }
                    }
                    if (flag == false) System.out.println("Нет животных с такой датой рождения");

                    break;

                case 4:
                    // вывод животных обоих списков
                    Output.outputAnimals(registry);
                    break;

                case 5:
                    //вывод счетчика всех животных
                    Output.outputCounterAllAnimals();
                    break;

                case 6:
                    exitProgramm = true;
                    break;

            }
        }

        return registry;

    }


    private static Registry animalСommands(Registry registry){
        boolean exitProgramm = false;
        boolean flag;

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
                flag = false;

                // вывод команд выбранного животного
                if (numberId < 200) {
                    for (int i = 0; i < registry.getPetsList().size(); i++) {
                        if (registry.getPetsList().get(i).getId() == numberId) {
                            Output.outputCommandsOneAnimal(registry.getPetsList().get(i));
                            flag = true;
                        }
                    }

                } else if (numberId > 200) {
                    for (int i = 0; i < registry.getPackAnimalsList().size(); i++) {
                        if (registry.getPackAnimalsList().get(i).getId() == numberId) {
                            Output.outputCommandsOneAnimal(registry.getPackAnimalsList().get(i));
                            flag = true;
                        }
                    }
                }

                if (flag == false) System.out.println("\nнет животного с таким id");

                break;

            case 3:
                // ввод новых команд животного
                numberId = menu.enterAnimalId();
                flag = false;

                List<String> tempCommands = new ArrayList<>();

                if (numberId < 200) {
                    for (int i = 0; i < registry.getPetsList().size(); i++) {
                        if (registry.getPetsList().get(i).getId() == numberId) {
                            tempCommands.addAll(registry.getPetsList().get(i).getCommands());
                            tempCommands.addAll(List.of(menu.changeСommands()));
                            registry.getPetsList().get(i).setCommands(tempCommands);
                            flag = true;
                        }
                    }

                } else if (numberId > 200) {
                    for (int i = 0; i < registry.getPackAnimalsList().size(); i++) {
                        if (registry.getPackAnimalsList().get(i).getId() == numberId) {
                            tempCommands.addAll(registry.getPackAnimalsList().get(i).getCommands());
                            tempCommands.addAll(List.of(menu.changeСommands()));
                            registry.getPackAnimalsList().get(i).setCommands(tempCommands);
                            flag = true;
                        }
                    }
                }

                if (flag == false) System.out.println("\nнет животного с таким id");

                break;

            case 4:
                exitProgramm = true;
                break;
            }
        }

        return registry;
    }



}
