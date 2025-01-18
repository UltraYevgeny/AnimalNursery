package services;

import java.io.IOException;

public class Counter implements AutoCloseable{
    private int counter = 0;
    private boolean isClosed = false;

    public void add() throws IOException {
        if (isClosed) throw new IOException("Нельзя вызвать, закрыт");
        this.counter++;
    }

    @Override
    public void close() throws Exception {
        if (!isClosed) {
            this.isClosed = true;
        } else {
            throw new IOException("ресурс уже закрыт");
        }

    }
}
