package animals.animal_species;


import animals.animals_types.PackAnimals;
import animals.animals_types.Pets;

import java.util.Date;
import java.util.List;


public class Hamster extends Pets {
    public Hamster() {}

    public Hamster(int id, String name, Date birthDate, List<String> commands) {

        super.setId(id);
        super.setName(name);
        super.setBirthDate(birthDate);
        super.setCommands(commands);
    }

    @Override
    public String toString(){
        return "ID: " + super.getId() + "; " +
                "Name: " + super.getName() + "; " +
                "Type: Hamster; " +
                "BirthDate: " + super.getBirthDate() + "; " +
                "Commands: " + super.getCommands() + ";";
    }


}
