package tasks;

public class Sequence {

    private static int idCounter = 0;

    public Sequence() {

    }

    public static int getNewId() {
        idCounter++;
        return idCounter;
    }

    public static int getLastId() {
        return idCounter;
    }
}