package observer.baby.second;

public class Father {
	Baby baby;

	public void setBaby(Baby baby) {
		this.baby = baby;
	}
	
	void observeBaby(){
		new Thread(){
			public void run(){
				while(true){
					if(baby.state.equals("crying")){
						System.out.println("Father: Do not cry!");
						baby.state="happy";
					}
				}
			}
		}.start();	
	}
}
