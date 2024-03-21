package application;

public class Player extends Character{
	
	Items[] items = new Items[4];
	int exp = 0;
	int expNeeded = 30;
	
	
	
	
	public void addExp(int amt) {
		exp += amt;
		if(exp >= expNeeded) {
			lvlUp(exp - expNeeded);
		}
	}
	
	public void lvlUp(int extra) {
		exp = extra;
		expNeeded = (int) 1.2 * expNeeded;
		
		//check if items are full and give reward accordingly
		
	}
	
	private void randReward() {
		
	}
	private void setReward() {
		
	}
}
