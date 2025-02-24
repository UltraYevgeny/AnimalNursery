import services.Core;

/**
 * @author Пинжин Евгений Иванович
 * @apiNote Программа: реестр питомника животных
 * @apiNote Клиентский класс
 * @version 1.01
 */
public class App {

    public static void main(String[] args) {

        // запуск с тестовыми данными
        //Core.run(DataForTest.testMetod());

        //запуск из класса конструктора
        //ClassAsConstructor classAsConstructor = new  ClassAsConstructor();
        //classAsConstructor.runRegistry();

        Core.run();

    }


}
