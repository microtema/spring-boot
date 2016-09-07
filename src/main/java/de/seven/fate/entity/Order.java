package de.seven.fate.entity;

import java.io.Serializable;

public class Order implements Serializable {

    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
