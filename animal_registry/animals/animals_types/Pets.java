package animals.animals_types;

import animals.Animals;

public class Pets extends Animals {
    final private static int formatId = 100;
    private static int id;

    public static int getPetsId() {
        if (id == 0) {
            id = formatId;
        }

        return ++id;}

}
