
package gamble;

public class JettonConcrete  implements Jetton{
   
	private int faceValue;//��ֵ

    public JettonConcrete(int face_value) {
		super();
		this.faceValue = face_value;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return faceValue;
	}

}
