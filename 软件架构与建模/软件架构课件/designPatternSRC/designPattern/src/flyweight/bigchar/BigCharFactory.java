package flyweight.bigchar;

import java.util.HashMap;

public class BigCharFactory {
    // �����Ѿ����ɵ�BigChar��ʵ��
    private HashMap pool = new HashMap();
    // Singletonģʽ
    private static BigCharFactory singleton = new BigCharFactory();
    // ���캯��
    private BigCharFactory() {
    }
    // ��ȡΨһ��ʵ��
    public static BigCharFactory getInstance() {
        return singleton;
    }
    // ���ɣ�����BigChar���ʵ��
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = (BigChar)pool.get("" + charname);
        if (bc == null) {
            bc = new BigChar(charname); // ����BigChar��ʵ��
            pool.put("" + charname, bc);
        }
        return bc;
    }
}
