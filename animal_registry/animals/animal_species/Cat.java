package animals.animal_species;

import animals.animals_types.PackAnimals;
import animals.animals_types.Pets;

import java.sql.Date;
import java.util.List;


public class Cat extends Pets {
    public Cat() {}

    public Cat(int id, String name, Date birthDate, List<String> commands) {

        super.setId(id);
        super.setName(name);
        super.setBirthDate(birthDate);
        super.setCommands(commands);

    }

    @Override
    public String toString(){
        return "ID: " + super.getId() + "; " +
                "Name: " + super.getName() + "; " +
                "Type: Cat; " +
                "BirthDate: " + super.getBirthDate() + "; " +
                "Commands: " + super.getCommands() + ";";
    }


}
