package animals.animal_species;


import animals.animals_types.PackAnimals;
import animals.animals_types.Pets;

import java.util.Date;
import java.util.List;


public class Dog extends Pets {
    public Dog() {}

    public Dog(int id, String name, Date birthDate, List<String> commands) {

        super.setId(id);
        super.setName(name);
        super.setBirthDate(birthDate);
        super.setCommands(commands);

    }

    @Override
    public String toString(){
        return "ID: " + super.getId() + "; " +
                "Name: " + super.getName() + "; " +
                "Type: Dog; " +
               "BirthDate: " + super.getBirthDate() + "; " +
               "Commands: " + super.getCommands() + ";";
    }

}
