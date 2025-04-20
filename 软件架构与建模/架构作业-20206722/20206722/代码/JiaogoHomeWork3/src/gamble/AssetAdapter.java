package gamble;


/**
 * AssertÊÊÅäÆ÷
 * @author Seirin
 *
 */
public class AssetAdapter implements Jetton {
	
	Asset ass;

	public AssetAdapter(Asset ass) {
		super();
		this.ass = ass;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return ass.getValue();

	}

	
}
