package view;

import animals.Animals;
import animals.animals_types.PackAnimals;
import animals.animals_types.Pets;
import services.AnimalClassIdentifier;

import java.io.IOException;
import java.util.*;

public class Menu {

    public int startMenu(){
        int numberMenuValue;
        System.out.println("\nМеню реестра животных");
        System.out.println("1. Добавить новое животное в реестр.\n" +
                            "2. Зайти в Меню работы с командами животных\n" +
                            "3. Вывести животных по дате рождения\n" +
                            "4. Вывести список всех животных\n" +
                            "5. Вывести общий счетчик животных\n" +
                            "6. Выйти из регистра");
        numberMenuValue = digitScan("Введите номер нужного меню: ");
        return numberMenuValue;
    }

    public int animalСommands(){
        int numberMenuValue;
        System.out.println("\nМеню работы с командами животных");
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

    public Date enterAnimalDob() throws IllegalArgumentException{
        return java.sql.Date.valueOf(stringScan("Введите День Рождения животного (например: 2000-01-01): "));}

    public Animals createAnimal() throws IOException {
        String[] commandsNewAnimal;
        Animals newAnimal;

        newAnimal = AnimalClassIdentifier.animalSpecies(stringScan("Введите Вид нового животного: "));
        newAnimal.setName(stringScan("Введите Имя нового животного: "));
        newAnimal.setBirthDate(java.sql.Date
                .valueOf(stringScan("Введите День Рождения нового животного (например: 2000-01-01): ")));
        commandsNewAnimal = stringScan("Введите Команды нового животного, через запятую: ").split(",");
        newAnimal.setCommands(deleteSpace(commandsNewAnimal));

        return newAnimal;

    }

    public List<String > changeСommands(){
        return deleteSpace(stringScan("Введите Новые команды животного, через запятую: ").split(","));
    }

    public List<String> deleteSpace(String[] arrayToChange){
        List<String> newArray = new ArrayList<>();
        for (String word : arrayToChange){
            if (!word.isEmpty() && !word.isBlank()) newArray.add(word.trim());
        }
        return newArray;
    }



    public int digitScan(String message) {
        Scanner in = new Scanner(System.in);

        System.out.print(message);

        while (!in.hasNextInt()) {
            System.out.print("\nЗначение не является числом, попробуйте еще раз: ");
            in.reset();
            in.next();
        }
        return in.nextInt();
    }

    public String stringScan(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
