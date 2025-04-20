package chainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        Support alice   = new NoSupport("Alice_NoSupport");
        Support bob     = new LimitSupport("Bob_LimitSupport", 100); //只能处理100以下的数
        Support charlie = new SpecialSupport("Charlie_SpecialSupport", 429); //只能处理429这一个数
        Support diana   = new LimitSupport("Diana_LimitSupport", 200); //只能处理200以下的数
        Support elmo    = new OddSupport("Elmo_OddSupport"); //只能处理奇数
        Support fred    = new LimitSupport("Fred_LimitSupport", 300); //只能处理三百以下的数
        // 形成职责链
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        // 制造各种问题
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}
