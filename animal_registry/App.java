import animals.animals_types.PackAnimals;
import services.Core;

public class App {

    //          Программа, может использоваться в различных системах,
    //          поэтому необходимо разработать класс в виде конструктора

    /**
     * @author Пинжин Евгений Иванович
     * @apiNote Программа: реестр питомника животных
     * @version 1.0
     */
    public static void main(String[] args) {

        Core.run(DataForTest.testMetod());

    }

}
