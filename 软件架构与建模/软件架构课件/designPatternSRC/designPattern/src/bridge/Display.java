package bridge;

public class Display {
    private DisplayImpl impl;
    public Display(DisplayImpl impl) {
        this.impl = impl;
    }
    public void open() { //显示前的处理
        impl.rawOpen();
    }
    public void print() { //显示处理
        impl.rawPrint();
    }
    public void close() { //显示后的处理
        impl.rawClose();
    }
    public final void display() {
        open();
        print();                    
        close();
    }
}
