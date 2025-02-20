package services;

import java.io.Closeable;
import java.io.IOException;

public class Counter implements Closeable {
    private static int counter;
    private static boolean isOpen = false;

    public void add() {
        counter++;
        isOpen = true;
    }

    public static int getCounter() {
        return counter;
    }

    public static boolean getIsIsOpen() {
        return isOpen;
    }

    public static void setCounter(int counter) {
        Counter.counter = counter;
    }

    @Override
    public void close() throws IOException {
        isOpen = false;
        if (Counter.isOpen) throw new IOException();
    }


}
