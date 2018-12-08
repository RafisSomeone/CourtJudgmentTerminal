package tree;

import Files.ItemInside.CourtType;

public class Court {
    private CourtType type;
    private int counter;

    public Court(CourtType type, int counter) {
        this.type = type;
        this.counter = counter;
    }

    public void increaseCounter() {
        counter++;
    }

    public CourtType getType() {
        return type;
    }

    public int getCounter() {
        return counter;
    }
}
