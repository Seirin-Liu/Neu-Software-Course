package Ex1;

public class Token {
    int code;
    int value;

    @Override
    public String toString() {
        return "Ex1.Token{" +
                "code=" + code +
                ", value=" + value +
                '}';
    }

    public Token(int code, int value) {
        this.code = code;
        this.value = value;
    }

    public Token() {
    }
}
