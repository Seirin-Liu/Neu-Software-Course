package interpreter.gui;

// <program> ::= program <command list>
public class ProgramNode extends Node {
    private Node commandListNode;
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public void execute() throws ExecuteException {
        commandListNode.execute();
    }
    public String toString() {
        return "[program " + commandListNode + "]";
    }
}
