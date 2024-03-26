package application;

public class enemies extends Character{

	public enemies() {
		// TODO Auto-generated constructor stub
		
	}
	private double[] getDistance(Player p) {
		double Px = (int) p.getX();
		double Py = (int) p.getY();
		double[] dis = new double[] {this.getX()-Px - this.getY()-Py};
		
		return dis;
	}
	public void follow(Player p) {
		double[] disToPlayer = getDistance(p);
		double xDis = disToPlayer[0];
		double yDis = disToPlayer[1];
		if(this.getX() > xDis) {
			this.changeX(-1);
		}else {
			this.changeX(1);
		}
		if(this.getY() > yDis) {
			this.changeY(-1);
		}else {
			this.changeY(1);
		}
	}
	

}
