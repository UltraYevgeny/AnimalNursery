import animals.Animals;
import animals.animal_species.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @apiNote тестовые данные, при необходимости их можно внести в программу
 */
public class DataForTest {
    private static List<Animals> testList = new ArrayList<>();

    public static List<Animals> testMetod(){

        testList.addFirst(new Dog(101,
                "Rupert",
                java.sql.Date.valueOf("2023-01-01"),
                new ArrayList<>(Arrays.asList("Sit", "Stay", "Fetch"))));

        testList.add(new Cat(102,
                "Sunny",
                java.sql.Date.valueOf("2019-05-15"),
                new ArrayList<>(Arrays.asList("Sit", "Pounce"))));

        testList.add(new Hamster(103,
                "Funken",
                java.sql.Date.valueOf("2024-03-10"),
                new ArrayList<>(Arrays.asList("Roll", "Hide"))));

        testList.add(new Horse(201,
                "Wind",
                java.sql.Date.valueOf("2024-07-21"),
                new ArrayList<>(Arrays.asList("Trot", "Canter", "Gallop"))));

        testList.add(new Camel(202,
                "Ice",
                java.sql.Date.valueOf("2016-11-03"),
                new ArrayList<>(Arrays.asList("Walk", "Carry Load"))));

        testList.add(new Donkey(203,
                "Golem",
                java.sql.Date.valueOf("2017-09-18"),
                new ArrayList<>(Arrays.asList("Walk", "Carry Load", "Bray"))));

        return testList;

    }
}
