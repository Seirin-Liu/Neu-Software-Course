package interpreter.gui;

public abstract class Node implements Executor {
    public abstract void parse(Context context) throws ParseException;
}
