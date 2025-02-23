package animals.animals_types;

import animals.Animals;


public class PackAnimals extends Animals {
    final private static int formatId = 200;
    private static int idCounter;

    public static int getPackAnimalsIdCounter() {
        if (idCounter == 0) {
            idCounter = formatId;
        }

        return ++idCounter;
    }

    public static void setPackAnimalsIdCounter(int id) {
        PackAnimals.idCounter = id;
    }
}
