package view;

import animals.Animals;
import animals.animals_types.PackAnimals;
import animals.animals_types.Pets;
import services.AnimalClassIdentifier;

import java.util.*;

public class Menu {

    public int startMenu(){
        int numberMenuValue;
        System.out.println("\nМеню реестра животных");
        System.out.println("1. Добавить новое животное в реестр.\n" +
                            "2. Зайти в Меню просмотра команд животных\n" +
                            "3. Вывести животных по дате рождения\n" +
                            "4. Выйти из регистра");
        numberMenuValue = digitScan("Введите номер нужного меню: ");
        return numberMenuValue;
    }

    public int animalСommands(){
        int numberMenuValue;
        System.out.println("\nМеню просмотра команд животных");
        System.out.println("1. Вывести список животных\n" +
                            "2. Выбрать животное, для просмотра его команд\n" +
                            "3. Выбрать животное, для ввода новых команд\n" +
                            "4. Вернутся в главное меню");
        numberMenuValue = digitScan("Введите номер нужного меню: ");
        return numberMenuValue;
    }

    public int enterAnimalId(){
        return digitScan("\nВведите ID животного: ");
    }

    public Date enterAnimalDob(){
        return java.sql.Date.valueOf(stringScan("Введите День Рождения животного: "));}

    public Animals createAnimal(){
        String[] commandsNewAnimal;
        Animals newAnimal;

        newAnimal = AnimalClassIdentifier.animalSpecies(stringScan("Введите Вид нового животного: "));
        newAnimal.setName(stringScan("Введите Имя нового животного: "));
        newAnimal.setBirthDate(java.sql.Date.valueOf(stringScan("Введите День Рождения нового животного: ")));
        commandsNewAnimal = stringScan("Введите Команды нового животного, через запятую: ").split(",");
        newAnimal.setCommands(List.of(commandsNewAnimal));

        if (newAnimal.getClass().getSuperclass() == PackAnimals.class){
            newAnimal.setId(PackAnimals.getPackAnimalsId());
        } else if (newAnimal.getClass().getSuperclass() == Pets.class){
            newAnimal.setId(Pets.getPetsId());
        }

        return newAnimal;

    }

    public String[] changeСommands(){
        return stringScan("Введите Новые команды животного, через запятую: ").split(",");
    }


    public int digitScan(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }

    public String stringScan(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
