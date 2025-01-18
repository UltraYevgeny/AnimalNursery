package animals.animals_types;

import animals.Animals;


public class PackAnimals extends Animals {
    final private static int formatId = 200;
    private static int id;

    public static int getPackAnimalsId() {
        if (id == 0) {
            id = formatId;
        }

        return ++id;
    }

}
