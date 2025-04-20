package Second.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Ŀ¼
 * @author Seirin
 *
 */
public class Menu extends Component{
	
	private List<Component> components; 
	private int level;
	
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


	public List<Component> getComponents() {
		return components;
	}

	public Menu(String name ,int level) {
		super(name);
		// TODO Auto-generated constructor stub
		this.level=level;
		components=new ArrayList<>();
	}

	
	@Override
	public void add(Component component) {
		// TODO Auto-generated method stub
		components.add(component);
	}

	@Override
	public void remove(Component component) {
		// TODO Auto-generated method stub
		components.remove(component);
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		//System.out.print("	");
		System.out.print(this.getName()+"||:\n");
		for(Component c:components) {
			for(int i=1;i<=level;i++) {
				System.out.print("	");
			}
			c.print();
		}
	}

}
