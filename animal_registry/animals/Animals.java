package animals;

import java.util.Date;
import java.util.List;

public abstract class Animals {

    //region Поля
    private int id;
    private String name;
    private Date birthDate;
    private List<String> commands;
    //endregion


    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}
}
