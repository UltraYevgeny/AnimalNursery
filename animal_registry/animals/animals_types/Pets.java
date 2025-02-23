package animals.animals_types;

import animals.Animals;

public class Pets extends Animals {
    final private static int formatId = 100;
    private static int idCounter;

    public static int getPetsIdCounter() {
        if (idCounter == 0) {
            idCounter = formatId;
        }

        return ++idCounter;}

    public static void setPetsIdCounter(int id) {
        Pets.idCounter = id;
    }

}
